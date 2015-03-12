package cn.gs.network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.AttributeKey;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.Message;
import cn.gs.network.utils.CheckSumStream;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2014年10月8日
 * 类说明：消息校验解码
 * 
 * 最后修改时间：2014年10月8日
 * 修改内容： 新建此类
 */
public class MessageDecoder extends LengthFieldBasedFrameDecoder {

	private AttributeKey<Integer> key = null;
	private volatile int pid;
	/**
	 * 校验包
	 */
	private final CheckSumStream checkSumStream;
	private int msgOffset;
	
	private static final int OFFSET_MAX_LIMIT_TO_MOD = 7;
	
	/**
	 * @param byteOrder
	 * @param maxFrameLength
	 * @param lengthFieldOffset
	 * @param lengthFieldLength
	 * @param lengthAdjustment
	 * @param initialBytesToStrip
	 * @param failFast
	 */
	public MessageDecoder() {
		super(4096, 0, 2, 0, 0);
		checkSumStream = new CheckSumStream();
	}

	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		key = AttributeKey.valueOf(String.valueOf(ctx.channel().hashCode()));
		ctx.fireChannelActive();
	}


	@Override
	protected ByteBuf extractFrame(ChannelHandlerContext ctx, ByteBuf buffer,
			int index, int length) {
		
		if(buffer.readableBytes() < 2){
            System.err.println("不够读取一个长度");
            ctx.close();
            return null;
	    }
		int size = buffer.readShort();
		
		if(buffer.readableBytes() < 1){
            System.err.println("不够读取一个校验和");
            ctx.close();
            return null;
	    }
		int checkSumByte = buffer.readUnsignedByte();
		
		try {
			checkSumStream.clearSum();
			buffer.getBytes(buffer.readerIndex(), checkSumStream,
			        buffer.readableBytes());
			if (checkSumByte != checkSumStream.getCheckSum()){
	            System.err.println("校验和错误, expected: " + checkSumStream.getCheckSum() + ", actual: " + checkSumByte);
	            ctx.close();
	            return null;
	        }
		} catch (Throwable e) {
			System.err.println(e.getMessage());
		}
		
		int offset = msgOffset++ & OFFSET_MAX_LIMIT_TO_MOD;
		
		if(buffer.readableBytes() < 1){
            System.err.println("不够读出一个偏移量");
            ctx.close();
            return null;
        }
        int bigOffset = buffer.readUnsignedByte();

        if (bigOffset != calculateVerificationBytes(msgOffset)){
            System.err.println("偏移量校验错误");
            ctx.close();
            return null;
        }

        if(buffer.readableBytes() < 2){
            System.err.println("不够读出一个cmd");
            ctx.close();
            return null;
        }
        int msgId = buffer.readUnsignedShort();

        int o = msgId >>> 13;

        msgId = msgId & 0x1fff;

        if (o != offset){
            System.err.println("wrong offset, msg " + msgId);
            ctx.close();
            return null;
        }
        
        byte[] bytes = new byte[size - 4];
        buffer.readBytes(bytes);
        if(pid == 0) {
        	pid = ctx.channel().attr(key).get();
        }
        IMessage message = Message.build(size, msgId, bytes, ctx.channel(), pid);
        ctx.fireChannelRead(message);
		return null;
	}
	
	private static int calculateVerificationBytes(int offset){
        int v = offset;
        v ^= v >> 8;
        v ^= v >> 4;
        v &= 0xff;
        return v;
    }

}

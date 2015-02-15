package cn.gs.network.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import cn.gs.network.message.IMessage;
import cn.gs.network.server.IServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2014年10月8日
 * 类说明：业务处理类
 * 
 * 最后修改时间：2014年10月8日
 * 修改内容： 新建此类
 */
public class MessageHandler extends SimpleChannelInboundHandler<IMessage>{

	private IServer server;
	
	public MessageHandler(IServer server) {
		
	}
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IMessage msg)
			throws Exception {
		server.handle(ctx, msg);
	}

}

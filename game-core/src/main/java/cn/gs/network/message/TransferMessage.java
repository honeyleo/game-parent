package cn.gs.network.message;

import com.google.protobuf.ByteString;

import io.netty.channel.Channel;
import cn.gs.network.message.PBMessagePro.PBMessage;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月13日
 * 类说明：
 * 
 * 最后修改时间：2015年2月13日
 * 修改内容： 新建此类
 */
public class TransferMessage extends AbstractMessage implements IMessage {

	
	protected TransferMessage(Channel channel, PBMessage pbMessage) {
		super(0, pbMessage.getCmd(), pbMessage.getData().toByteArray(), channel, pbMessage.getSid());
	}
	
	public static IMessage transfer(PBMessage pbMessage, Channel channel) {
		return new TransferMessage(channel, pbMessage);
	}
	
	public static PBMessage transfer(IMessage message) {
		PBMessage.Builder builder = PBMessage.newBuilder();
		builder.setCmd(message.cmd()).setId(String.valueOf(message.pid()))
				.setData(ByteString.copyFrom(message.data()));
		return builder.build();
	}
	
}

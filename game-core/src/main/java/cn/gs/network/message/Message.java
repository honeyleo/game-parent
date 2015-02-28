package cn.gs.network.message;

import io.netty.channel.Channel;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public class Message extends AbstractMessage implements IMessage {

	protected Message(int size, int cmd, byte[] data, Channel channel) {
		super(size, cmd, data, channel);
	}
	
	public static IMessage build(int size, int cmd, byte[] data, Channel channel) {
		return new Message(size, cmd, data, channel);
	}

}

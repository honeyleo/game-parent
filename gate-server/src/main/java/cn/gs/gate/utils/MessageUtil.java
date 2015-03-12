package cn.gs.gate.utils;

import io.netty.channel.Channel;

import java.util.List;

import cn.gs.gate.server.GateServer;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.TransferMessage;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月11日
 * 类说明：
 * 
 * 最后修改时间：2015年3月11日
 * 修改内容： 新建此类
 */
public class MessageUtil {

	/**
	 * 发送消息到游戏服务器
	 * @param server
	 * @param message
	 */
	public static void send_to_game(int server, IMessage message) {
		List<Channel> channels = GateServer.getInstance().getGameChannel(server);
		if(channels != null) {
			Channel channel = channels.get(0);
			channel.write(TransferMessage.transfer(message));
		}
	}
}

package cn.gs.gate.utils;

import io.netty.channel.Channel;

import java.util.List;

import cn.gs.gate.Player;
import cn.gs.gate.player.manager.PlayerManager;
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
	
	/**
	 * 全服通知
	 * @param message 信息
	 */
	public static void tell_world_message(IMessage message){
		Player[] players = PlayerManager.getPlayers().values().toArray(new Player[0]);
		for (Player player : players) {
			MessageUtil.tell_player_message(player, message);
		}
	}
	
	/**
	 * 消息通知
	 * @param player
	 * @param message
	 */
	public static void tell_player_message(Player player, IMessage message) {
		
	}
	
	public static void tell_player_message(int playerId, IMessage message) {
		
	}
}

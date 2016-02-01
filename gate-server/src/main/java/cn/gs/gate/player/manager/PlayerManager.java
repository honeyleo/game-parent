package cn.gs.gate.player.manager;

import java.util.concurrent.ConcurrentHashMap;

import cn.gs.gate.Player;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月11日
 * 类说明：
 * 
 * 最后修改时间：2015年3月11日
 * 修改内容： 新建此类
 */
public class PlayerManager {

	private static ConcurrentHashMap<Integer, Player> players = new ConcurrentHashMap<Integer, Player>();
	public static Player getPlayer(int pid) {
		return players.get(pid);
	}
	
	public static ConcurrentHashMap<Integer, Player> getPlayers() {
		return players;
	}
}

package cn.gs.game;

import cn.gs.game.server.GameServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月15日
 * 类说明：
 * 
 * 最后修改时间：2015年2月15日
 * 修改内容： 新建此类
 */
public class GameServerStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(GameServer.getInstance()).start();
	}

}

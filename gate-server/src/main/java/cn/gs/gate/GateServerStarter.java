package cn.gs.gate;

import cn.gs.gate.server.GateServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public class GateServerStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(GateServer.getInstance()).start();
	}

}

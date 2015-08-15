package cn.gs.gate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.gs.Cmd;
import cn.gs.gate.server.handler.ReqRegisterGameServerHandler;
import cn.gs.handler.Handler;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月11日
 * 类说明：
 * 
 * 最后修改时间：2015年3月11日
 * 修改内容： 新建此类
 */
public class HandlerMgr {

	protected static final Map<Integer, Handler>  MAP_HANDLERS = new ConcurrentHashMap<Integer, Handler>();
	
	static {
		MAP_HANDLERS.put(Cmd.Game2Gate.REQ_REGISTER_GAME_SERVER, new ReqRegisterGameServerHandler());
	}
	
	public static Handler getHandler(int cmd) {
		return MAP_HANDLERS.get(cmd);
	}
}

package cn.gs.world;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.gs.handler.Handler;
import cn.gs.world.server.handler.ReqRegisterWorldForGateHandler;
import cn.gs.world.server.handler.ReqRegisterWorldHandler;

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
		MAP_HANDLERS.put(23101, new ReqRegisterWorldForGateHandler());
		MAP_HANDLERS.put(23103, new ReqRegisterWorldHandler());
	}
	
	public static Handler getHandler(int cmd) {
		return MAP_HANDLERS.get(cmd);
	}
}

package cn.gs.world.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.impl.InnerServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月15日
 * 类说明：
 * 
 * 最后修改时间：2015年2月15日
 * 修改内容： 新建此类
 */
public class WorldServer extends InnerServer{

	private static Object obj = new Object();
	private static WorldServer server;
	
	//GameServer通信列表
	private static ConcurrentHashMap<Integer, Vector<Channel>> gameSessions = new ConcurrentHashMap<Integer, Vector<Channel>>();
	//GateServer通信列表
	private static ConcurrentHashMap<Integer, Vector<Channel>> gateSessions = new ConcurrentHashMap<Integer, Vector<Channel>>();
		
	private static final String defaultInnerServerConfig="server-config/inner-server-config.xml";
	
	public WorldServer(){
		super(defaultInnerServerConfig);
	}
	
	public WorldServer(String innerServerConfig){
		super(innerServerConfig);
	}
	
	public static WorldServer getInstance(){
		synchronized (obj) {
			if(server == null){
				server = new WorldServer();
			}
		}
		return server;
	}
	@Override
	protected void init(){
		super.init();
	}
	
	@Override
	public void run(){
		super.run();
	}

	@Override
	public void handle(ChannelHandlerContext ctx, PBMessage pbMessage) {
		
	}
	
	/**
	 * 游戏服务器注册
	 * @param id 游戏服务器编号
	 * @param session 通讯接口
	 */
	public synchronized void registerGameServer(int id, Channel session){
		synchronized (gameSessions) {
			Vector<Channel> sessions = null;
			if(gameSessions.containsKey(id)){
				sessions = gameSessions.get(id);
			}else{
				sessions = new Vector<Channel>();
				gameSessions.put(id, sessions);
			}
			sessions.add(session);
		}
	}
	
	/**
	 * 网关服务器注册
	 * @param id 网关服务器编号
	 * @param session 通讯接口
	 */
	public synchronized void registerGateServer(int id, Channel session){
		synchronized (gateSessions) {
			Vector<Channel> sessions = null;
			if(gateSessions.containsKey(id)){
				sessions = gateSessions.get(id);
			}else{
				sessions = new Vector<Channel>();
				gateSessions.put(id, sessions);
			}
			sessions.add(session);
		}
	}

	public static ConcurrentHashMap<Integer, Vector<Channel>> getGameSessions() {
		return gameSessions;
	}

	public static ConcurrentHashMap<Integer, Vector<Channel>> getGateSessions() {
		return gateSessions;
	}
}

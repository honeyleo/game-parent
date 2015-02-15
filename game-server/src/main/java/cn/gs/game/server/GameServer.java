package cn.gs.game.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.impl.ClientServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月15日
 * 类说明：
 * 
 * 最后修改时间：2015年2月15日
 * 修改内容： 新建此类
 */
public class GameServer extends ClientServer {

	private static Object obj = new Object();
	private static GameServer server;
	//默认内部客户服务器配置文件
	private static final String defaultClientServerConfig="server-config/client-server-config.xml";
	
	public GameServer(String serverConfig){
		super(serverConfig);
	}
	
	public GameServer(){
		this(defaultClientServerConfig);
	}
	
	public static GameServer getInstance(String serverConfig, String gameConfig){
		synchronized (obj) {
			if(server == null){
				server = new GameServer(serverConfig);
			}
		}
		return server;
	}
	
	public static GameServer getInstance(){
		synchronized (obj) {
			if(server == null){
				server = new GameServer();
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

	@Override
	public void register(Channel channel, int type) {
		
	}
}

package cn.gs.gate.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.impl.ClientServer;
import cn.gs.network.server.impl.InnerServer;
import cn.gs.network.server.impl.NettyServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public class GateServer extends NettyServer {

	private static Object obj = new Object();
	private static GateServer server;
	//内部通讯服务器
	private static InnerServer innerServer = null;
	//连接世界服务器
	private static ClientServer clientServer = null;
	
	//默认NETTY服务器配置文件
	private static final String defaultMinaServerConfig="server-config/netty-server-config.xml";
	//默认内部服务器配置文件
	private static final String defaultInnerServerConfig="server-config/inner-server-config.xml";
	//默认内部客户服务器配置文件
	private static final String defaultClientServerConfig="server-config/client-server-config.xml";
		
	public GateServer(){
		this(defaultMinaServerConfig, defaultInnerServerConfig, defaultClientServerConfig);
	}
	
	public GateServer(String minaServerConfig, String innerServerConfig, String clientServerConfig){
		super(minaServerConfig);
		innerServer = new InnerConnectServer(innerServerConfig);
		clientServer = new ClientConnectServer(clientServerConfig);
	}
	
	public static GateServer getInstance(String minaServerConfig, String innerServerConfig, String clientServerConfig){
		synchronized (obj) {
			if(server == null){
				server = new GateServer(minaServerConfig, innerServerConfig, clientServerConfig);
			}
		}
		return server;
	}
	
	public static GateServer getInstance(){
		synchronized (obj) {
			if(server == null){
				server = new GateServer();
			}
		}
		return server;
	}
	
	@Override
	public void run() {
		super.run();
		new Thread(innerServer).start();
		new Thread(clientServer).start();
	}
	@Override
	public void handle(ChannelHandlerContext ctx, IMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void stop() {
		// TODO Auto-generated method stub
		
	}
	
	private class InnerConnectServer extends InnerServer {

		protected InnerConnectServer(String serverConfig) {
			super(serverConfig);
		}

		@Override
		public void handle(ChannelHandlerContext ctx, PBMessage pbMessage) {
			
		}
		
	}
	
	private class ClientConnectServer extends ClientServer {

		/**
		 * @param serverConfig
		 */
		protected ClientConnectServer(String serverConfig) {
			super(serverConfig);
		}

		@Override
		public void handle(ChannelHandlerContext ctx, PBMessage pbMessage) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void register(Channel channel, int type) {
			// TODO Auto-generated method stub
			
		}
		
	}

}

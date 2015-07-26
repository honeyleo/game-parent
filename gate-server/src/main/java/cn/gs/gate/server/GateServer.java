package cn.gs.gate.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import cn.gs.disruptor.Disruptor;
import cn.gs.disruptor.MultiThreadDisruptor;
import cn.gs.gate.HandlerMgr;
import cn.gs.gate.Player;
import cn.gs.gate.player.manager.PlayerManager;
import cn.gs.gate.utils.MessageUtil;
import cn.gs.handler.Handler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.message.ServerInfo_Protocol.ServerInfoPro;
import cn.gs.network.message.TransferMessage;
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
	
	//GameServer通信列表
	private static ConcurrentHashMap<Integer, List<Channel>> gameChannels = new ConcurrentHashMap<Integer, List<Channel>>();
		
	private static final ConcurrentHashMap<Integer, Channel> players_channels = new ConcurrentHashMap<Integer, Channel>();
	
	private static Disruptor handlerDisruptor = new MultiThreadDisruptor("Handler_Worker_", 20);
	
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
	
	/**
	 * 游戏服务器注册
	 * @param id 游戏服务器编号
	 * @param channel 通讯接口
	 */
	public synchronized void registerGameServer(int id, Channel channel){
		synchronized (gameChannels) {
			List<Channel> channels = gameChannels.get(id);
			if(channels==null){
				channels = new ArrayList<Channel>();
				gameChannels.put(id, channels);
			}
			channels.add(channel);	
		}
	}
	
	/**
	 * 获得与游戏服务器通讯channel
	 * @return
	 */
	public List<Channel> getGameChannel(int server){
		return gameChannels.get(server);
	}
	
	/**
	 * 注册玩家
	 * @param pid
	 * @param channel
	 */
	public void registerPlayerChannel(int pid, Channel channel) {
		synchronized (channel) {
			players_channels.put(pid, channel);
		}
	}
	@Override
	public void handle(ChannelHandlerContext ctx, final IMessage message) {
		final Handler handler = HandlerMgr.getHandler(message.cmd());
		if(handler != null) {
			handlerDisruptor.publish(new Runnable() {
				
				@Override
				public void run() {
					handler.handle(message);
				}
			});
		} else {
			Player player = PlayerManager.getPlayer(message.pid());
			if(player != null) {
				int serverId = player.serverId;
				MessageUtil.send_to_game(serverId, message);
			}
		}
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
		public void handle(final ChannelHandlerContext ctx, final PBMessage pbMessage) {
			final IMessage message = TransferMessage.transfer(pbMessage, ctx.channel());
			final Handler handler = HandlerMgr.getHandler(pbMessage.getCmd());
			if(handler != null && message.status() == 0) {
				handlerDisruptor.publish(new Runnable() {
					
					@Override
					public void run() {
						handler.handle(message);
					}
				});
			} else {
				//网关服务器没有对应处理器，则可能会是全服通知或者对应玩家
				if(pbMessage.getPlayerId() == 0) {
					//通知网关上的所有玩家
					MessageUtil.tell_world_message(message);
				} else if(pbMessage.getPlayerIdsCount() > 0) {
					//通知玩家列表中的所有玩家
					for(Integer playerId : pbMessage.getPlayerIdsList()) {
						MessageUtil.tell_player_message(playerId, message);;
					}
				} else {
					//输出消息给玩家
					MessageUtil.tell_player_message(message.pid(), message);
				}
			}
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
			final IMessage message = TransferMessage.transfer(pbMessage, ctx.channel());
			final Handler handler = HandlerMgr.getHandler(pbMessage.getCmd());
			if(handler != null && message.status() == 0) {
				handlerDisruptor.publish(new Runnable() {
					
					@Override
					public void run() {
						handler.handle(message);
					}
				});
			} else {
				//网关服务器没有对应处理器，则可能会是全服通知或者对应玩家
				if(pbMessage.getPlayerId() == 0) {
					//通知网关上的所有玩家
					MessageUtil.tell_world_message(message);
				} else if(pbMessage.getPlayerIdsCount() > 0) {
					//通知玩家列表中的所有玩家
					for(Integer playerId : pbMessage.getPlayerIdsList()) {
						MessageUtil.tell_player_message(playerId, message);;
					}
				} else {
					//输出消息给玩家
					MessageUtil.tell_player_message(message.pid(), message);
				}
			}
			
		}

		@Override
		public void register(Channel channel, int type) {
			
			PBMessage.Builder builder = PBMessage.newBuilder();
			builder.setCmd(23101);
			ServerInfoPro.Builder serverInfoBuilder = ServerInfoPro.newBuilder();
			serverInfoBuilder.setId(getServer_id());
			serverInfoBuilder.setName(getServer_name());
			builder.setData(serverInfoBuilder.build().toByteString());
			channel.writeAndFlush(builder.build());
		}
		
	}

}

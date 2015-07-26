package cn.gs.game.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.gs.disruptor.Disruptor;
import cn.gs.disruptor.MultiThreadDisruptor;
import cn.gs.game.HandlerMgr;
import cn.gs.handler.Handler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.message.ServerInfo_Protocol.ServerInfoPro;
import cn.gs.network.message.TransferMessage;
import cn.gs.network.server.IServer;
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

	private static final Logger LOG = LoggerFactory.getLogger(GameServer.class);
	private static Object obj = new Object();
	private static GameServer server;
	//默认内部客户服务器配置文件
	private static final String defaultClientServerConfig="server-config/client-server-config.xml";
	
	private static Disruptor handlerDisruptor = new MultiThreadDisruptor("Handler_Worker_", 20);
	
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
		final IMessage message = TransferMessage.transfer(pbMessage, ctx.channel());
		final Handler handler = HandlerMgr.getHandler(message.cmd());
		if(handler != null) {
			handlerDisruptor.publish(new Runnable() {
				
				@Override
				public void run() {
					handler.handle(message);
					
				}
			});
		} else {
			LOG.warn("没有找到对应指令----cmd={}", message.cmd());
		}
	}

	@Override
	public void register(Channel channel, int type) {
		switch (type) {
		case IServer.GATE_SERVER:
			PBMessage.Builder builder = PBMessage.newBuilder();
			builder.setCmd(21101);
			ServerInfoPro.Builder serverInfoBuilder = ServerInfoPro.newBuilder();
			serverInfoBuilder.setId(getServer_id());
			serverInfoBuilder.setName(getServer_name());
			builder.setData(serverInfoBuilder.build().toByteString());
			channel.writeAndFlush(builder.build());
			break;
		case IServer.WORLD_SERVER:
			PBMessage.Builder builder2 = PBMessage.newBuilder();
			builder2.setCmd(23103);
			ServerInfoPro.Builder serverInfoBuilder2 = ServerInfoPro.newBuilder();
			serverInfoBuilder2.setId(getServer_id());
			serverInfoBuilder2.setName(getServer_name());
			builder2.setData(serverInfoBuilder2.build().toByteString());
			channel.writeAndFlush(builder2.build());
			break;
	}
	}
}

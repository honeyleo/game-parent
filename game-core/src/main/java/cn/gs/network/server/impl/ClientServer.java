package cn.gs.network.server.impl;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.gs.network.codec.PBMessageHandler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.IServer;
import cn.gs.network.server.Server;
import cn.gs.network.server.config.ClientServerConfig;
import cn.gs.network.server.config.ServerInfo;
import cn.gs.network.server.loader.ClientServerConfigXmlLoader;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao 创建时间：2015年2月14日 类说明：
 * 
 *         最后修改时间：2015年2月14日 修改内容： 新建此类
 */
public abstract class ClientServer extends Server implements IServer {

	private Logger log = LoggerFactory.getLogger(ClientServer.class);
	private static int gateSessionNumber = 1;

	private static int worldSessionNumber = 1;

	protected HashMap<Integer, List<Channel>> gateSessions = new HashMap<Integer, List<Channel>>();
	protected List<Channel> worldSessions = new ArrayList<Channel>();

	protected ClientServer(String serverConfig) {
		this(serverConfig, gateSessionNumber, worldSessionNumber);
	}

	protected ClientServer(String serverConfig, int gateSessionNumber,
			int worldSessionNumber) {
		super(new ClientServerConfigXmlLoader().load(serverConfig));
		ClientServer.gateSessionNumber = gateSessionNumber;
		ClientServer.worldSessionNumber = worldSessionNumber;
	}

	protected void init() {
		super.init();
	}

	public void run() {
		super.run();
		EventLoopGroup workerGroup = new NioEventLoopGroup(4,
				new DefaultThreadFactory("Netty-Worker-Thread"));
		Bootstrap bootstrap = new Bootstrap();
		final IServer server = this;
		try {
			bootstrap
					.group(workerGroup)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.option(ChannelOption.MAX_MESSAGES_PER_READ, 4096)
					.option(ChannelOption.ALLOCATOR,
							PooledByteBufAllocator.DEFAULT)
					.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch)
								throws Exception {
							ch.pipeline()
									.addLast(
											"frameDecoder",
											new LengthFieldBasedFrameDecoder(
													4096, 0, 2, 0, 2))
									.addLast(
											"protobufDecoder",
											new ProtobufDecoder(PBMessage
													.getDefaultInstance()))
									.addLast(new PBMessageHandler(server))
									.addLast("frameEncoder",
											new LengthFieldPrepender(2))
									.addLast("protobufEncoder",
											new ProtobufEncoder());
						}

					});
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		ClientServerConfig config = (ClientServerConfig) this.serverConfig;
		if (config != null) {
			if (config.getWorldServer() != null) {
				int connected = 0;
				while (connected < worldSessionNumber) {
					ServerInfo worldServerInfo = config.getWorldServer();
					try {
						Channel channel = bootstrap
								.connect(worldServerInfo.getIp(),
										worldServerInfo.getPort()).sync()
								.channel();
						add(channel, worldServerInfo.getId(),
								IServer.WORLD_SERVER);
						register(channel, IServer.WORLD_SERVER);
					} catch (InterruptedException e) {
						log.error("连接服务器【ip={}，port={}】异常",
								worldServerInfo.getIp(),
								worldServerInfo.getPort());
					}
					connected++;
				}
			}
			for (int i = 0; i < config.getGateServers().size(); i++) {
				int connected = 0;
				ServerInfo info = (ServerInfo) config.getGateServers().get(i);
				while (connected < gateSessionNumber) {
					try {
						Channel channel = bootstrap
								.connect(info.getIp(), info.getPort()).sync()
								.channel();
						add(channel, info.getId(), IServer.GATE_SERVER);
						register(channel, IServer.GATE_SERVER);
					} catch (InterruptedException e) {
						log.error("连接服务器【ip={}，port={}】异常", info.getIp(),
								info.getPort());
					}
					connected++;
				}
			}
		}
	}

	public void add(Channel channel, int id, int type) {
		if (type == 1) {
			synchronized (this.gateSessions) {
				List<Channel> sessions = this.gateSessions.get(Integer
						.valueOf(id));
				if (sessions == null) {
					sessions = new ArrayList<Channel>();
					this.gateSessions.put(Integer.valueOf(id), sessions);
				}
				sessions.add(channel);
			}
		}
		if (type == 3) {
			synchronized (this.worldSessions) {
				this.worldSessions.add(channel);
			}
		}
	}

	public abstract void register(Channel channel, int type);

	@Override
	public void handle(ChannelHandlerContext ctx, IMessage message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void stop() {
		// TODO Auto-generated method stub

	}

}

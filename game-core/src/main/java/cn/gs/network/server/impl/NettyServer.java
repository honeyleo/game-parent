package cn.gs.network.server.impl;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.gs.network.codec.MessageDecoder;
import cn.gs.network.codec.MessageHandler;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.IServer;
import cn.gs.network.server.Server;
import cn.gs.network.server.config.NettyServerConfig;
import cn.gs.network.server.loader.NettyServerConfigXmlLoader;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public abstract class NettyServer extends Server implements IServer {

	private final static Logger log = LoggerFactory.getLogger(NettyServer.class);
	private int port;
	/**
	 * @param serverConfig
	 */
	protected NettyServer(String serverConfig) {
		super(new NettyServerConfigXmlLoader().load(serverConfig));
		init();
	}

	protected void init() {
		super.init();
		this.port = ((NettyServerConfig)this.serverConfig).getMina_port();
	}
	
	public void run() {
		super.run();
		new Thread(new ConnectServer(this)).start();
	}
	
	
	@Override
	public void handle(ChannelHandlerContext ctx, PBMessage pbMessage) {
		
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


	private class ConnectServer implements Runnable {

		private NettyServer server;
		
		public ConnectServer(NettyServer server) {
			this.server = server;
		}
		@Override
		public void run() {
			int port = NettyServer.this.port;
			EventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("Boss-Thread"));
			EventLoopGroup workerGroup = new NioEventLoopGroup(2, new DefaultThreadFactory("Netty-Worker-Thread"));
			
			try {
				ServerBootstrap serverBootstrap = new ServerBootstrap();
				
				serverBootstrap.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
					.option(ChannelOption.SO_BACKLOG, 1024)
					.option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.option(ChannelOption.SO_RCVBUF, 2048)
					.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline()
								.addLast("idleStateHandler", new IdleStateHandler(60, 60, 0))
								.addLast(new MessageDecoder())
								.addLast(new MessageHandler(ConnectServer.this.server))
								;
						}
					});
				serverBootstrap.bind(port).channel();
				log.info("服务器启动成功，开始监听{} 端口...", port);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		
	}
}

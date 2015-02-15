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
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.util.concurrent.DefaultThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.gs.network.codec.PBMessageHandler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.IServer;
import cn.gs.network.server.Server;
import cn.gs.network.server.config.InnerServerConfig;
import cn.gs.network.server.loader.InnerServerConfigXmlLoader;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public abstract class InnerServer extends Server implements IServer {

	private int port;
	
	protected InnerServer(String serverConfig) {
		super(new InnerServerConfigXmlLoader().load(serverConfig));
	}
	
	protected void init() {
	     super.init();
	     this.port = ((InnerServerConfig)this.serverConfig).getPort();
	}

	public void run() {
		super.run();
		new Thread(new ConnectServer(this)).start();
	}
	
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

	private class ConnectServer implements Runnable {

		private Logger log = LoggerFactory.getLogger(ConnectServer.class);
		
		private InnerServer server;
		
		public ConnectServer(InnerServer server) {
			this.server = server;
		}
		@Override
		public void run() {
			EventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("Boss-Thread"));
			EventLoopGroup workerGroup = new NioEventLoopGroup(4, new DefaultThreadFactory("Netty-Worker-Thread"));
			
			try {
				ServerBootstrap serverBootstrap = new ServerBootstrap();
				
				serverBootstrap.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 100)
					.option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.option(ChannelOption.MAX_MESSAGES_PER_READ, 4096)
					.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
					.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline()
							.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(4096, 0, 2, 0, 2))
							.addLast("protobufDecoder", new ProtobufDecoder(PBMessage.getDefaultInstance()))
							.addLast(new PBMessageHandler(ConnectServer.this.server))
							.addLast("frameEncoder", new LengthFieldPrepender(2))
							.addLast("protobufEncoder", new ProtobufEncoder())
							;
						}
					});
				serverBootstrap.bind(port).channel();
				log.info("内部服务器开始监听{} 端口...", port);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}
}

package cn.gs.network.server;

import io.netty.channel.ChannelHandlerContext;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public interface IServer {

	public static final int GATE_SERVER = 1;
	public static final int GAME_SERVER = 2;
	public static final int WORLD_SERVER = 3;
	/**
	 * 消息处理方法
	 * @param ctx
	 * @param message
	 */
	void handle(ChannelHandlerContext ctx, IMessage message);
	/**
	 * 内部服务器消息处理方法
	 * @param ctx
	 * @param pbMessage
	 */
	void handle(ChannelHandlerContext ctx, PBMessage pbMessage);
	
	void channelRegistered(ChannelHandlerContext ctx) throws Exception;
	
	void channelActive(ChannelHandlerContext ctx) throws Exception;
	
	void channelUnregistered(ChannelHandlerContext ctx) throws Exception;
	
	void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception;
	
	void userEventTriggered(ChannelHandlerContext ctx, Object evt);
}

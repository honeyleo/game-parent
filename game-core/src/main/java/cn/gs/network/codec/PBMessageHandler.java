package cn.gs.network.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.server.IServer;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2014年10月10日
 * 类说明：
 * 
 * 最后修改时间：2014年10月10日
 * 修改内容： 新建此类
 */
public class PBMessageHandler extends SimpleChannelInboundHandler<PBMessage> {

	private IServer server;
	
	public PBMessageHandler(IServer server) {
		this.server = server;
	}
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
			PBMessage msg) throws Exception {
		server.handle(ctx, msg);
	}

}

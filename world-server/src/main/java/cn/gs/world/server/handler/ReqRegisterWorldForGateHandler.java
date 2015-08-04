package cn.gs.world.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;

import cn.gs.handler.Handler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.message.ServerInfo_Protocol.ServerInfoPro;
import cn.gs.world.server.WorldServer;
public class ReqRegisterWorldForGateHandler implements Handler{

	private static final Logger LOG = LoggerFactory.getLogger(ReqRegisterWorldForGateHandler.class);

	@Override
	public void handle(IMessage message){
		try{
			ServerInfoPro serverInfoPro = ServerInfoPro.parseFrom(message.data());
			//注册网关服务器
			WorldServer.getInstance().registerGateServer(serverInfoPro.getId(), message.channel());
			
			LOG.info("网关服务器【id={},name={}】注册----》世界服务器【id={},name={}】成功", new Object[]{
					serverInfoPro.getId(), serverInfoPro.getName(), WorldServer.getInstance().getServer_id(), WorldServer.getInstance().getServer_name()
			});
			
			//返回成功消息
			PBMessage.Builder resBuilder = PBMessage.newBuilder();
			ServerInfoPro.Builder builder = ServerInfoPro.newBuilder();
			builder.setId(WorldServer.getInstance().getServer_id());
			builder.setName(WorldServer.getInstance().getServer_name());
			resBuilder.setCmd(23102).setData(builder.build().toByteString());
			message.channel().writeAndFlush(resBuilder.build());
		} catch (InvalidProtocolBufferException e) {
			LOG.error("网关服务器注册世界服务器失败", e);
		}
	}
}
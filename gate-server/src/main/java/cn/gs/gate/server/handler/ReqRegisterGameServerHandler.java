package cn.gs.gate.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;

import cn.gs.Cmd;
import cn.gs.gate.server.GateServer;
import cn.gs.handler.Handler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.PBMessagePro.PBMessage;
import cn.gs.network.message.ServerInfo_Protocol.ServerInfoPro;

public class ReqRegisterGameServerHandler implements Handler {

	private static final Logger LOG = LoggerFactory.getLogger(ReqRegisterGameServerHandler.class);
	
	@Override
	public void handle(IMessage message) {
		try {
			ServerInfoPro serverInfoPro = ServerInfoPro.parseFrom(message.data());
			GateServer.getInstance().registerGameServer(serverInfoPro.getId(), message.channel());
			LOG.info("游戏服务器【id={},name={}】注册----》网关服务器【id={},name={}】", new Object[]{serverInfoPro.getId(), serverInfoPro.getName(), 
					GateServer.getInstance().getServer_id(), GateServer.getInstance().getServer_name()});
			//返回注册成功消息
			ServerInfoPro.Builder resServerInfoProBuilder = ServerInfoPro.newBuilder();
			resServerInfoProBuilder.setId(GateServer.getInstance().getServer_id()).setName(GateServer.getInstance().getServer_name());
			PBMessage.Builder builder = PBMessage.newBuilder();
			builder.setCmd(Cmd.Gate2Game.RES_REGISTER_GAME_SERVER).setData(resServerInfoProBuilder.build().toByteString());
			message.channel().writeAndFlush(builder.build());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
	}

}

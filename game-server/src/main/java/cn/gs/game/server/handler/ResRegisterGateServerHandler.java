package cn.gs.game.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;

import cn.gs.game.server.GameServer;
import cn.gs.handler.Handler;
import cn.gs.network.message.IMessage;
import cn.gs.network.message.ServerInfo_Protocol.ServerInfoPro;

public class ResRegisterGateServerHandler implements Handler {

	private static final Logger LOG = LoggerFactory.getLogger(ResRegisterGateServerHandler.class);
	
	@Override
	public void handle(IMessage message) {
		try {
			ServerInfoPro serverInfoPro = ServerInfoPro.parseFrom(message.data());
			LOG.info("游戏服务器【id={},name={}】注册----》网关服务器【id={},name={}】成功。", 
					new Object[]{GameServer.getServer_id(), GameServer.getInstance().getServer_name(), serverInfoPro.getId(), serverInfoPro.getName()});
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}

	}

}

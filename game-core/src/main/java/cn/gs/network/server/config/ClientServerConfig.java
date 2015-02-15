package cn.gs.network.server.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public class ClientServerConfig extends ServerConfig {

	private List<ServerInfo> gateServers = new ArrayList<ServerInfo>();
	
	private ServerInfo worldServer;

	public List<ServerInfo> getGateServers() {
		return gateServers;
	}

	public void setGateServers(List<ServerInfo> gateServers) {
		this.gateServers = gateServers;
	}

	public ServerInfo getWorldServer() {
		return worldServer;
	}

	public void setWorldServer(ServerInfo worldServer) {
		this.worldServer = worldServer;
	}
	
	
}

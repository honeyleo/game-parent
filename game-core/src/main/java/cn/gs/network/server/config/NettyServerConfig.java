package cn.gs.network.server.config;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年2月14日
 * 类说明：
 * 
 * 最后修改时间：2015年2月14日
 * 修改内容： 新建此类
 */
public class NettyServerConfig extends ServerConfig {

	private int mina_port;

	public int getMina_port() {
		return mina_port;
	}

	public void setMina_port(int mina_port) {
		this.mina_port = mina_port;
	}
	
	
}

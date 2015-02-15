package cn.gs.network.server;

import org.slf4j.LoggerFactory;

import cn.gs.network.server.config.ServerConfig;

public abstract class Server implements Runnable {

	private String server_name;
	public static int server_id;
	private String server_web;
	protected ServerConfig serverConfig;
	public static final String DEFAULT_MAIN_THREAD = "Main";

	protected Server(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
		if (this.serverConfig != null) {
			init();
		}
	}

	protected void init() {

	}

	public String getServer_name() {
		return server_name;
	}

	public static int getServer_id() {
		return server_id;
	}

	public String getServer_web() {
		return server_web;
	}

	public void run() {
		Runtime.getRuntime().addShutdownHook(
				new Thread(new CloseByExit(this.server_name)));
	}

	protected abstract void stop();

	private class CloseByExit implements Runnable {
		private org.slf4j.Logger log = LoggerFactory
				.getLogger(CloseByExit.class);
		private String server_name;

		public CloseByExit(String server_name) {
			this.server_name = server_name;
		}

		public void run() {
			Server.this.stop();
			this.log.info(this.server_name + " Stop!");
		}
	}
}

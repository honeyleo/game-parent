package cn.gs;

public class Cmd {

	public static interface Game2Gate {
		
		public static final int REQ_REGISTER_GAME_SERVER = 21101;
		
	}
	
	public static interface Gate2Game {
		public static final int RES_REGISTER_GAME_SERVER = 21101;
	}
}

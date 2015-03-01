package cn.gs.cache;

import java.io.Serializable;

import cn.gs.cache.impl.MemoryCache;

public class CacheTest {

	public static class Player implements Serializable {
		
		private static final long serialVersionUID = 6655953654216670490L;
		private int id;
		
		public Player(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "player[id = " + id + "]";
		}
		
	}
	private static MemoryCache<Integer, Player> players = new MemoryCache<Integer, Player>();
	public static void main(String[] args) {
		for(int i = 0 ; i < 6000; i ++) {
			int id = i + 1;
			Player player = new CacheTest.Player(id);
			players.put(id, player);
		}
		players.put(3000, new Player(1000));
		System.out.println(players.get(2000));
		
		System.out.println(players);
	}

}

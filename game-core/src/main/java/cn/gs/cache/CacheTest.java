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
	
	public static class Task implements Runnable {

		private int start;
		private int end;
		
		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public void run() {
			for(int i = start ; i < end; i ++) {
				int id = i;
				Player player = new CacheTest.Player(id);
				players.put(id, player);
			}
		}
		
	}
	private static MemoryCache<Integer, Player> players = new MemoryCache<Integer, Player>();
	public static void main(String[] args) {
		Thread t1 = new Thread(new Task(0, 2000));
		Thread t2 = new Thread(new Task(2000, 4000));
		Thread t3 = new Thread(new Task(4000, 6000));
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(players.get(2998));
		
		System.out.println(players.getCache().size());
	}

}

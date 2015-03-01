package cn.gs.cache.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.gs.cache.Cache;
import cn.gs.cache.structs.LRULinkedHashMap;
import cn.gs.cache.structs.WaitingUpdateQueue;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月1日
 * 类说明：
 * 
 * 最后修改时间：2015年3月1日
 * 修改内容： 新建此类
 */
public class MemoryCache<K, V> implements Cache<K, V>, Serializable {
	private static final long serialVersionUID = -3656956459941919920L;
	private static int MAX_SIZE = 5000;
	private static int PER_SAVE = 5;
	protected int saveSize;
	private LRULinkedHashMap<K, V> cache;
	private WaitingUpdateQueue<V> queue = new WaitingUpdateQueue<V>();

	public MemoryCache() {
		this(MAX_SIZE, PER_SAVE);
	}

	public MemoryCache(int maxSize, int saveSize) {
		this.cache = new LRULinkedHashMap<K, V>(maxSize);
		this.saveSize = saveSize;
	}

	public synchronized void put(K key, V value) {
		if (this.cache.containsKey(key)) {
			this.queue.add(value);
			return;
		}
		this.cache.put(key, value);
	}

	public V get(K key) {
		V value = this.cache.get(key);

		return value;
	}

	public void remove(K key) {
		V value = this.cache.get(key);
		if (value != null) {
			this.cache.remove(key);

			this.queue.remove(value);
		}
	}

	public List<V> getWaitingSave(int size) {
		ArrayList<V> waiting = new ArrayList<V>();

		int i = 0;

		V value = this.queue.poll();
		while (value != null) {
			waiting.add(value);
			i++;
			if (i == size) {
				break;
			}
			value = this.queue.poll();
		}
		return waiting;
	}

	public List<V> getAllWaitingSave() {
		ArrayList<V> waiting = new ArrayList<V>();

		V value = this.queue.poll();
		while (value != null) {
			waiting.add(value);

			value = this.queue.poll();
		}
		return waiting;
	}

	public LRULinkedHashMap<K, V> getCache() {
		return this.cache;
	}
}

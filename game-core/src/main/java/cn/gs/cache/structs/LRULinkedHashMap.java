package cn.gs.cache.structs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月1日
 * 类说明：
 * 
 * 最后修改时间：2015年3月1日
 * 修改内容： 新建此类
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = -3791412708654730531L;
	private int max = 16;
	private Lock lock = new ReentrantLock();

	public LRULinkedHashMap(int max) {
		super(16, 0.75F, true);
		this.max = max;
	}

	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > this.max;
	}

	public V get(Object k) {
		try {
			this.lock.lock();
			return super.get(k);
		} finally {
			this.lock.unlock();
		}
	}

	public V put(K key, V value) {
		try {
			this.lock.lock();
			return super.put(key, value);
		} finally {
			this.lock.unlock();
		}
	}

	public V remove(Object key) {
		try {
			this.lock.lock();
			return super.remove(key);
		} finally {
			this.lock.unlock();
		}
	}
}

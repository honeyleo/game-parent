package cn.gs.cache.structs;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月1日
 * 类说明：
 * 
 * 最后修改时间：2015年3月1日
 * 修改内容： 新建此类
 */
public class WaitingUpdateQueue<V> implements Serializable {
	private static final long serialVersionUID = -6020192336030291965L;
	private ConcurrentLinkedQueue<V> queue = new ConcurrentLinkedQueue<V>();
	private ConcurrentHashSet<V> set = new ConcurrentHashSet<V>();

	public void add(V value) {
		if (!this.set.contains(value)) {
			this.set.add(value);

			this.queue.add(value);
		}
	}

	public V poll() {
		V value = this.queue.poll();
		if (value != null) {
			this.set.remove(value);
		}
		return value;
	}

	public boolean contains(V value) {
		return this.set.contains(value);
	}

	public void remove(V value) {
		this.set.remove(value);
		this.queue.remove(value);
	}
}
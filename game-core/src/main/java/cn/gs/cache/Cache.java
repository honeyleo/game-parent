package cn.gs.cache;

import java.util.List;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月1日
 * 类说明：
 * 
 * 最后修改时间：2015年3月1日
 * 修改内容： 新建此类
 */
public abstract interface Cache<K, V> {
	
  public abstract V get(K paramK);
  
  public abstract void put(K paramK, V paramV);
  
  public abstract void remove(K paramK);
  
  public abstract List<V> getWaitingSave(int paramInt);
}

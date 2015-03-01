package cn.gs.cache.structs;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @copyright SHENZHEN RONG WANG HUI ZHI TECHNOLOGY CORP
 * @author Lyon.liao
 * 创建时间：2015年3月1日
 * 类说明：
 * 
 * 最后修改时间：2015年3月1日
 * 修改内容： 新建此类
 */
public class ConcurrentHashSet<E> extends AbstractSet<E> implements Set<E>
{
   private final ConcurrentMap<E, Object> theMap;

   private static final Object dummy = new Object();

   public ConcurrentHashSet()
   {
      theMap = new ConcurrentHashMap<E, Object>();
   }

   @Override
   public int size()
   {
      return theMap.size();
   }

   @Override
   public Iterator<E> iterator()
   {
      return theMap.keySet().iterator();
   }

   @Override
   public boolean isEmpty()
   {
      return theMap.isEmpty();
   }

   @Override
   public boolean add(final E o)
   {
      return theMap.put(o, ConcurrentHashSet.dummy) == null;
   }

   @Override
   public boolean contains(final Object o)
   {
      return theMap.containsKey(o);
   }

   @Override
   public void clear()
   {
      theMap.clear();
   }

   @Override
   public boolean remove(final Object o)
   {
      return theMap.remove(o) == ConcurrentHashSet.dummy;
   }

   public boolean addIfAbsent(final E o)
   {
      Object obj = theMap.putIfAbsent(o, ConcurrentHashSet.dummy);

      return obj == null;
   }

}

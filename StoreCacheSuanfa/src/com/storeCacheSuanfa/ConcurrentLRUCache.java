package com.storeCacheSuanfa;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * * 最频繁访问驻留缓存算法 * Created by ysc on 7/18/16.
 */
public class ConcurrentLRUCache<K, V> {

	private int maxCacheSize;//最大缓存数量
	private Map<K, CacheItem<V>> cache = new ConcurrentHashMap<>();//缓存
	private AtomicLong totalEvictCount = new AtomicLong();//记录从缓存中移除的元素个数
	private AtomicLong hitCount = new AtomicLong();//记录每次get后get到元素的次数
	private AtomicLong notHitCount = new AtomicLong();//记录每次get后都没有get到的次数

	public ConcurrentLRUCache(int maxCacheSize) {
		//创建一个大小为maxCacheSize，加载因子为1，线程并发为10的缓存
		cache = new ConcurrentHashMap<>(maxCacheSize, 1, 10);
		this.maxCacheSize = maxCacheSize;
	}

	public String getStatus() {
		StringBuilder status = new StringBuilder();

		long total = hitCount.get() + notHitCount.get();
		//统计
		status.append("最大缓存数量: ").append(maxCacheSize).append("\n").append("当前缓存数量: ").append(getActualCacheSize())
				.append("\n").append("驱逐缓存次数: ").append(totalEvictCount.get()).append("\n").append("命中缓存次数: ")
				.append(hitCount.get()).append("\n").append("未命中缓存次数: ").append(notHitCount.get()).append("\n")
				.append("缓存命中比例: ").append(total == 0 ? 0 : hitCount.get() / (float) total * 100).append(" %\n");

		return status.toString();
	}

	public String getKeyAndHitCount() {
		StringBuilder status = new StringBuilder();
		AtomicInteger i = new AtomicInteger();
		cache.entrySet().stream().sorted((a, b) -> b.getValue().getCount() - a.getValue().getCount())
				.forEach(entry -> status.append(i.incrementAndGet()).append("\t").append(entry.getKey()).append("\t")
						.append(entry.getValue().getCount()).append("\n"));

		return status.toString();
	}

	public int getMaxCacheSize() {
		return maxCacheSize;
	}

	public int getActualCacheSize() {
		return cache.size();
	}

	public Map<K, CacheItem<V>> getCache() {
		return Collections.unmodifiableMap(cache);
	}

	public AtomicLong getTotalEvictCount() {
		return totalEvictCount;
	}

	public long getHitCount() {
		return hitCount.longValue();
	}

	public long getNotHitCount() {
		return notHitCount.longValue();
	}

	public void put(K key, V value) {
		//如果缓存的元素大小大于或等于最大缓存数，那么就要释放掉一些元素，这里释放的是最先存进来的元素。
		if (cache.size() >= maxCacheSize) {
			// evict count
			int evictCount = (int) (maxCacheSize * 0.1);//一次性释放的个数
			if (evictCount < 1) {
				evictCount = 1;
			}
			totalEvictCount.addAndGet(evictCount);
			cache.entrySet().stream().sorted((a, b) -> a.getValue().getCount() - b.getValue().getCount())
					.limit(evictCount).forEach(entry -> cache.remove(entry.getKey()));
			return;
		}
		cache.put(key, new CacheItem<V>(value, new AtomicInteger()));
	}

	public V get(K key) {
		CacheItem<V> item = cache.get(key);
		if (item != null) {
			item.hit();
			hitCount.incrementAndGet();
			return item.getValue();
		}
		notHitCount.incrementAndGet();
		return null;
	}
	/**
	 * 缓存项
	 * @author Administrator
	 *
	 * @param <V>
	 */
	private static class CacheItem<V> {

		private V value;
		private AtomicInteger count;//记录自己被get到的次数

		public CacheItem(V value, AtomicInteger count) {
			this.value = value;
			this.count = count;
		}

		public void hit() {
			this.count.incrementAndGet();
		}

		public V getValue() {
			return value;
		}

		public int getCount() {
			return count.get();
		}
	}

	public static void main(String[] args) {
		ConcurrentLRUCache<Integer, Integer> cache = new ConcurrentLRUCache<Integer, Integer>(5);
		for (int i = 0; i < 9; i++) {
			cache.put(i, i);
			if (i % 2 == 0) {
				for (int j = 0; j < i + 2; j++) {
					cache.get(i);
				}
			}
		}
		System.out.println(cache.getStatus());
		System.out.println(cache.getKeyAndHitCount());
	}
}
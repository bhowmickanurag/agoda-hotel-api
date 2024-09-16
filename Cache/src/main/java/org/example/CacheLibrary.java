package org.example;

import java.util.HashMap;
import java.util.Map;
import org.example.models.CachePolicyType;

public class CacheLibrary<K, V> {
  private final Map<K, V> storage;
  private final int capacity;
  private final CachePolicy<K> cachePolicy;
  private final CacheLibrary<K, V> nextLevelCache;


  public CacheLibrary(int capacity, CachePolicyType cachePolicyType, CacheLibrary<K, V> nextLevelCache) {
    CacheFactory<K> cacheFactory = new CacheFactory<K>();
    this.cachePolicy = cacheFactory.getCachePolicy(cachePolicyType);
    this.storage = new HashMap<>();
    this.capacity = capacity;
    this.nextLevelCache = nextLevelCache;
  }

  public V get(K key) {
    if (storage.containsKey(key)) {
      cachePolicy.insertOrAccessKey(key);
      return storage.get(key);
    }
    if (nextLevelCache != null) {
      return nextLevelCache.get(key);
    }
    System.out.println("Cache miss for key " + key);
    return null;
  }

  public synchronized void put(K key, V value) {
    if (storage.size() < capacity) {
      cachePolicy.insertOrAccessKey(key);
      storage.put(key, value);
    } else if (nextLevelCache != null) {
      nextLevelCache.put(key, value);
    } else {
      K keyRemoved = cachePolicy.removeKey();
      storage.remove(keyRemoved);
      this.put(key, value);
    }
  }
}

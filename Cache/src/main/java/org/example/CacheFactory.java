package org.example;

import org.example.models.CachePolicyType;

public class CacheFactory<K> {

  public CachePolicy<K> getCachePolicy(CachePolicyType cachePolicyType) {
    switch (cachePolicyType) {
      case LRU -> {
        return new LruCachePolicy<K>();
      }
      case LFU -> {
        return new LfuCachePolicy<K>();
      }
    }
    return null;
  }
}

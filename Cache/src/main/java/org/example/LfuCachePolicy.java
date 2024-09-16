package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.example.models.LfuNode;

public class LfuCachePolicy<K> implements CachePolicy<K> {

  private final Map<K, LfuNode<K>> map;
  private final PriorityQueue<LfuNode<K>> minHeap;

  public LfuCachePolicy() {
    map = new HashMap<>();
    minHeap = new PriorityQueue<>((a, b) -> a.getFrequency().get() - b.getFrequency().get());
  }

  @Override
  public synchronized void insertOrAccessKey(K key) {
    if (map.containsKey(key)) {
      LfuNode<K> node = map.get(key);
      minHeap.remove(node);
      node.incrementFrequency();
      minHeap.offer(node);
    } else {
      LfuNode<K> node = new LfuNode<>(key);
      minHeap.offer(node);
      map.put(key, node);
    }
  }

  @Override
  public synchronized K removeKey() {
    K key = minHeap.poll().getKey();
    map.remove(key);
    return key;
  }
}

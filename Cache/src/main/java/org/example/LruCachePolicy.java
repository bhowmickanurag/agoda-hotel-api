package org.example;

import java.util.HashMap;
import java.util.Map;
import org.example.models.LruNode;

public class LruCachePolicy<K> implements CachePolicy<K> {

  private final Map<K, LruNode<K>> map;
  private final LinkedListHelper<K> linkedListHelper;

  public LruCachePolicy() {
    map = new HashMap<>();
    linkedListHelper = new LinkedListHelper<>();
  }

  @Override
  public synchronized void insertOrAccessKey(K key) {
    if (map.containsKey(key)) {
      LruNode<K> node = map.get(key);
      linkedListHelper.moveNodeToLast(node);
    } else {
      LruNode<K> node = linkedListHelper.insertAtLast(key);
      map.put(key, node);
    }
  }

  @Override
  public synchronized K removeKey() {
    K key = linkedListHelper.deleteFromHead();
    map.remove(key);
    return key;
  }
}

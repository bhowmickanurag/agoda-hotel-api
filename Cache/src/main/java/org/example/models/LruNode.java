package org.example.models;

import lombok.Data;

@Data
public class LruNode<K> {

  private K key;
  private LruNode<K> prev;
  private LruNode<K> next;

  public LruNode(K key) {
    this.key = key;
    this.prev = null;
    this.next = null;
  }
}

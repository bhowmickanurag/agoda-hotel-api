package org.example;

import lombok.SneakyThrows;
import org.example.models.LruNode;

public class LinkedListHelper<K> {
  private LruNode<K> head;
  private LruNode<K> tail;

  public LinkedListHelper() {
    this.head = null;
    this.tail = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  @SneakyThrows
  public synchronized LruNode<K> insertAtLast(K key) {
    LruNode<K> node = new LruNode<>(key);
    if (isEmpty()) {
      this.head = node;
    } else {
        tail.setNext(node);
        node.setPrev(tail);
    }
    this.tail = node;
    return node;
  }

  @SneakyThrows
  public synchronized void moveNodeToLast(LruNode<K> node) {
    node.getPrev().setNext(node.getNext());
    node.getNext().setPrev(node.getPrev());
    tail.setNext(node);
    node.setPrev(tail);
    node.setNext(null);
    tail = node;
  }

  @SneakyThrows
  public synchronized K deleteFromHead() {
    K key = head.getKey();
    head = head.getNext();
    return key;
  }

}

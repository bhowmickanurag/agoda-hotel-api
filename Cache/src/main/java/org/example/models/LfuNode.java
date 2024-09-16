package org.example.models;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;

@Data
public class LfuNode<K> {

  private K key;
  private AtomicInteger frequency;

  public LfuNode(K key) {
    this.key = key;
    this.frequency = new AtomicInteger(1);
  }

  public void incrementFrequency() {
    frequency.incrementAndGet();
  }
}

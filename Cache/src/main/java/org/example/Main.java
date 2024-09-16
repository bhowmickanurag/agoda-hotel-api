package org.example;

import org.example.models.CachePolicyType;

public class Main {

  public static void main(String[] args) {

    CacheLibrary<Integer, String> cacheLibrary = new CacheLibrary<Integer, String>(5, CachePolicyType.LRU, null);
    cacheLibrary.put(1, "1");
    cacheLibrary.put(2, "2");
    cacheLibrary.put(3, "3");
    System.out.println(cacheLibrary.get(2));
    cacheLibrary.put(4, "4");
    cacheLibrary.put(5, "5");
    cacheLibrary.put(6, "6");
    System.out.println(cacheLibrary.get(2));
    System.out.println(cacheLibrary.get(1));
    cacheLibrary.put(6, "6");
  }
}
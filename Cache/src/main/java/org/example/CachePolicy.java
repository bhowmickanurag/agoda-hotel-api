package org.example;

public interface CachePolicy<K> {

    void insertOrAccessKey(K key);

    K removeKey();
}

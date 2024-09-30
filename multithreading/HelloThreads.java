package org.example.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class HelloThreads {

    public static void main(String[] args) {
        BlockingDeque<Integer> blockingDeque = (BlockingDeque<Integer>) new ArrayBlockingQueue<Integer>(4);

        Producer producer = new Producer(blockingDeque);
        Consumer consumer = new Consumer(blockingDeque);

        Thread prodcuerThread = new Thread(producer);
        Thread consmerThread = new Thread(consumer);

        prodcuerThread.start();
        consmerThread.start();
    }
}

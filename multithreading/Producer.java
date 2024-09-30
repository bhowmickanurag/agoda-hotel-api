package org.example.multithreading;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable{

    BlockingDeque<Integer> blockingDeque;

    public Producer(BlockingDeque<Integer> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }
    @Override
    public void run() {
            for(int i = 0 ;i <= 4 ; i++) {
                try {
                    blockingDeque.put(i);
                } catch (InterruptedException e) {
                    System.out.println("queue is full");
                }
            }
    }

}

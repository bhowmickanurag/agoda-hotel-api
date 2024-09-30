package org.example.multithreading;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable{


    BlockingDeque<Integer> blockingDeque;

    public Consumer(BlockingDeque<Integer> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        int i= 0;
        while(i != 4) {
            try {
                i = blockingDeque.take();
            } catch (InterruptedException e) {
                // noothing in thread
            }
        }
    }


}

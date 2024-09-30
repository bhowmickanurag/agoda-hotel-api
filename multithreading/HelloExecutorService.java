package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloExecutorService {

    HelloExecutorService() {

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4 ; i++) {
                    System.out.println("Thread 1 " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4 ; i++) {
                    System.out.println("Thread 2 " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t1 = new Thread(r1);

        executorService.execute(r1);
        executorService.execute(r2);
        executorService.shutdown();
    }
}

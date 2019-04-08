package org.sweetycode.tij4.c21.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tiantian on 2019/4/6.
 */
public class TestDrive {
    public static void main(String[] args) {
        BlockingQueue<Integer> pipeline = new ArrayBlockingQueue<Integer>(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i ++) {
            executorService.submit(new Consumer(i, pipeline));
            executorService.submit(new Producer(i, pipeline));
        }

        executorService.shutdown();
    }
}

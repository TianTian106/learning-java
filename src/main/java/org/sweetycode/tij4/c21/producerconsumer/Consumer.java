package org.sweetycode.tij4.c21.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by tiantian on 2019/4/6.
 */
public class Consumer implements Runnable {
    int id;
    BlockingQueue<Integer> pipeline;

    public Consumer(int id, BlockingQueue<Integer> pipeline) {
        this.id = id;
        this.pipeline = pipeline;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer " + id + " consumes " + pipeline.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

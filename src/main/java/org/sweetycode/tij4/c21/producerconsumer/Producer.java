package org.sweetycode.tij4.c21.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tiantian on 2019/4/6.
 */
public class Producer implements Runnable {
    private static AtomicInteger productId = new AtomicInteger(0);

    private int id;
    BlockingQueue<Integer> pipeline;

    public Producer(int id, BlockingQueue<Integer> pipeline) {
        this.id = id;
        this.pipeline = pipeline;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int var = productId.incrementAndGet();
                System.out.println("Producer " + id + " produce " + var);
                pipeline.put(var);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

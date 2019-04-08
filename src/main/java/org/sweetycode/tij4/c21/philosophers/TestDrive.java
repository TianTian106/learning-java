package org.sweetycode.tij4.c21.philosophers;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tiantian on 2019/4/5.
 */
public class TestDrive{
    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[5];
        for (int i = 0; i < 5; i ++) {
            chopsticks[i] = new Chopstick(i);
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 5; i ++) {
            threadPoolExecutor.submit(new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % 5]));
        }
    }
}

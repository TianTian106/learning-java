package org.sweetycode.tij4.c21.aqs.barrier;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by tiantian on 2019/4/8.
 */
public class Worker implements Callable<Integer> {
    private int id;
    private int[] array;
    CyclicBarrier cyclicBarrier ;

    public Worker(int id, int[] array, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.array = array;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i: array) {
            sum += i;
        }

        System.out.println("worker " + id + " has finished its work");
        cyclicBarrier.await();
        System.out.println("returning result of worker " + id);
        return sum;
    }
}
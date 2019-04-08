package org.sweetycode.tij4.c21.aqs.barrier;

import org.sweetycode.leetcode.util.ConvertUtil;

import java.util.concurrent.*;

/**
 * Created by tiantian on 2019/4/8.
 */
public class DyadicArrayElementSum {


    public Integer getResult(int[][] array) throws ExecutionException, InterruptedException {
        int len = array.length;
        Integer result = 0;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(len,len,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        FutureTask<Integer>[] futureTaskArray = new FutureTask[len];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(len);
        for (int i = 0; i < len; i ++) {
            futureTaskArray[i] = new FutureTask<Integer>(new Worker(i, array[i],cyclicBarrier));
            threadPoolExecutor.submit(futureTaskArray[i]);
        }

        for (int i = 0; i < len; i ++) {
            result += futureTaskArray[i].get();
        }
        threadPoolExecutor.shutdown();
        return result;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] array = ConvertUtil.stringToIntegerDyadicArray("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]");
        DyadicArrayElementSum dyadicArrayElementSum = new DyadicArrayElementSum();
        Integer result = dyadicArrayElementSum.getResult(array);
        System.out.println(result);
    }
}

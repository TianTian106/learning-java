package org.sweetycode.tij4.c21.aqs.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tiantian on 2019/4/8.
 */
public class Driver {
    public void driving(Integer passengerNum) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        CountDownLatch busReadySignal = new CountDownLatch(1);
        CountDownLatch allGetOnBusSignal = new CountDownLatch(passengerNum);
        for (int i = 1; i <= passengerNum; i ++) {
            threadPoolExecutor.submit(new Passenger(i, busReadySignal, allGetOnBusSignal));
        }

        System.out.println("Waiting for bus... ");
        System.out.println("Bus is coming!");
        busReadySignal.countDown();

        allGetOnBusSignal.await(600000, TimeUnit.MILLISECONDS);
        System.out.println("Bus is started up!");
        System.out.println("I wanna see the world!");
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        Driver driver = new Driver();
        driver.driving(10);
    }


}

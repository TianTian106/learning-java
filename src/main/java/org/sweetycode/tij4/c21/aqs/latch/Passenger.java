package org.sweetycode.tij4.c21.aqs.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tiantian on 2019/4/8.
 */
public class Passenger implements Runnable {
    private int id;
    private CountDownLatch busReadySignal;
    private CountDownLatch allGetOnBusSignal;

    public Passenger(int id, CountDownLatch busReadySignal, CountDownLatch allGetOnBusSignal) {
        this.id = id;
        this.busReadySignal = busReadySignal;
        this.allGetOnBusSignal = allGetOnBusSignal;
    }

    @Override
    public void run() {
        try {
            busReadySignal.await();
            System.out.println("Passenger " + id + " get on bus.");
            allGetOnBusSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

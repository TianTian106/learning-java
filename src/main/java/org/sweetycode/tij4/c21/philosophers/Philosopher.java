package org.sweetycode.tij4.c21.philosophers;

import java.util.concurrent.Callable;

/**
 * Created by tiantian on 2019/4/5.
 */
public class Philosopher implements Callable<Integer>{
    private Integer id;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(Integer id, Chopstick left, Chopstick right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer call() {
        while (true) {
            if (left.take()) {
                if (right.take()) {
                    eat();
                    right.put();
                }
                left.put();
            }
            think();
        }
    }

    public void eat() {
        System.out.println("Philosopher " + id + " begin eating with " + right.getId() + " and " + left.getId() + ".  ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Philosopher " + id + " end eating.");
    }

    public void think() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

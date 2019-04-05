package org.sweetycode.tij4.c21.philosophers;

/**
 * Created by tiantian on 2019/4/5.
 */
public class Chopstick {
    private Integer id;
    private boolean taken = false;

    public Chopstick(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public synchronized boolean take() {
        if (!taken) {
            taken = true;
            return true;
        }
        return false;
    }

    public void put() {
        this.taken = false;
    }


}

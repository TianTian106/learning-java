package org.sweetycode.designpattern.behavioral.strategy.simDuck;

/**
 * Created by tiantian on 02/09/2018.
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly with wings.");
    }
}

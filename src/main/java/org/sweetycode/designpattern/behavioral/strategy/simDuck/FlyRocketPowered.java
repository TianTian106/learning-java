package org.sweetycode.designpattern.behavioral.strategy.simDuck;

/**
 * Created by tiantian on 02/09/2018.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly rocket powered");
    }
}

package org.sweetycode.designpattern.behavioral.strategy.simDuck;

/**
 * Created by tiantian on 02/09/2018.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

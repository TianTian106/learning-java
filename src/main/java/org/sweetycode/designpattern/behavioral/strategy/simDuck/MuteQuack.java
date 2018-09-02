package org.sweetycode.designpattern.behavioral.strategy.simDuck;

/**
 * Created by tiantian on 02/09/2018.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Mute quack");
    }
}

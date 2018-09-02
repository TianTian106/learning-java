package org.sweetycode.designpattern.behavioral.strategy.simDuck;

/**
 * Created by tiantian on 02/09/2018.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}

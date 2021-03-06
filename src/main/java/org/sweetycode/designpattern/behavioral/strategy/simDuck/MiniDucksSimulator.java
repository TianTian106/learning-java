package org.sweetycode.designpattern.behavioral.strategy.simDuck;

/**
 * Created by tiantian on 02/09/2018.
 */
public class MiniDucksSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();

        mallard.display();
        mallard.performFly();
        mallard.performQuack();


        Duck model = new ModelDuck();

        model.display();
        model.performFly();
        model.performQuack();

        model.setFlyBehavior(new FlyRocketPowered());

        model.performFly();

    }
}

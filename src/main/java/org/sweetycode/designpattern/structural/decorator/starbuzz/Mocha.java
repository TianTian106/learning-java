package org.sweetycode.designpattern.structural.decorator.starbuzz;

/**
 * Created by tiantian on 02/09/2018.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .2 + beverage.cost();
    }
}

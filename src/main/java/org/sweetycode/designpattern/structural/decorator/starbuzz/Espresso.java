package org.sweetycode.designpattern.structural.decorator.starbuzz;

/**
 * Created by tiantian on 02/09/2018.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

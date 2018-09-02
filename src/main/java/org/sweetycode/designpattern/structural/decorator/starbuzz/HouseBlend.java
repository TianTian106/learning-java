package org.sweetycode.designpattern.structural.decorator.starbuzz;

/**
 * Created by tiantian on 02/09/2018.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}

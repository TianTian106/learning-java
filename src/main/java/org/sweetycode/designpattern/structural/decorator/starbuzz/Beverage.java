package org.sweetycode.designpattern.structural.decorator.starbuzz;

/**
 * Created by tiantian on 02/09/2018.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

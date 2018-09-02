package org.sweetycode.designpattern.structural.decorator.starbuzz;

/**
 * Created by tiantian on 02/09/2018.
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new Whip(new Mocha(new Mocha(new Espresso())));
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new Whip(new Mocha(new Soy(new Espresso())));
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}

package org.sweetycode.designpattern.creational.factory.pizzastore;

/**
 * Created by tiantian on 02/09/2018.
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        nyStore.orderPizza("cheese");

        PizzaStore chicagoStroe = new ChicagoPizzaStore();
        chicagoStroe.orderPizza("cheese");
    }
}

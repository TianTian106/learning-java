package org.sweetycode.designpattern.creational.factory.pizzastore;

/**
 * Created by tiantian on 02/09/2018.
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else return null;
    }
}

package org.sweetycode.designpattern.behavioral.Mediator;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: 中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。
 * MVC 框架，其中C（控制器）就是 M（模型）和 V（视图）的中介者。
 * 优点： 1、降低了类的复杂度，将一对多转化成了一对一。 2、各个类之间的解耦。 3、符合迪米特原则（最少知识原则）。
 * 缺点：中介者会庞大，变得复杂难以维护。
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! Jonh!");
        john.sendMessage("Hi! Robert!");
    }
}

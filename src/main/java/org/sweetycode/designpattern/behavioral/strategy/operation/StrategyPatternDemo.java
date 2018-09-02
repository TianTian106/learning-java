package org.sweetycode.designpattern.behavioral.strategy.operation;

/**
 * Created by tiantian on 02/09/2018.
 * @Description: 策略模式（Strategy Pattern），一个类的行为或其算法可以在运行时更改。
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context.setStrategy(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        context.setStrategy(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}

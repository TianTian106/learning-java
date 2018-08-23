package org.sweetycode.designpattern.behavioral.command;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description: 命令模式（command Pattern），解决命令的请求者和命令的实现者之间的耦合关系。
 * 请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 * 四个角色：
 * Command：定义命令的统一接口
 * ConcreteCommand：Command接口的实现者，用来执行具体的命令，某些情况下可以直接用来充当Receiver。
 * Receiver：命令的实际执行者
 * Invoker：命令的请求者，是命令模式中最重要的角色。这个角色用来对各个命令进行控制。
 */
public class CommandPatternDemo {
    public static void main(String[] args) {

        // Receiver
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder  = new SellStock(abcStock);

        // Invoker
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();

    }
}

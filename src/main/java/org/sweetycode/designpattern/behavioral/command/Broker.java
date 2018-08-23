package org.sweetycode.designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description: Invoker角色：命令的请求者，是命令模式中最重要的角色。这个角色用来对各个命令进行控制。
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order: orderList) {
            order.execute();
        }

        orderList.clear();
    }

}

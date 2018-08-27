package org.sweetycode.designpattern.behavioral.command.stock;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description: Receiver角色：命令的实际执行者
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                "} bought");
    }

    public void sell() {
        System.out.println("Stock{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                "} sold");
    }

}

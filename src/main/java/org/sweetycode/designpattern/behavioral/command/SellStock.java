package org.sweetycode.designpattern.behavioral.command;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description: ConcreteCommand角色：Command接口的实现者，用来执行具体的命令，某些情况下可以直接用来充当Receiver。
 */
public class SellStock implements Order{
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}

package org.sweetycode.designpattern.behavioral.command.transaction;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: Command（抽象命令对象）：它是命令对象的抽象（父类），可以是接口、抽象类或者普通类（案例中使用接口），它定义了一组命令对象的统一业务接口方法
 */
public interface Command {
    void execute();
    void undo();
}

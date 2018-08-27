package org.sweetycode.designpattern.behavioral.command.transaction;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: DataDao（业务数据操作对象：请求调用者）：它是具体请求的调用者，拥有了一个命令对象（Command）的引用，在insert方法中实现了对应命令方法的调用（提交事务、回滚事务）。
 */
public class DataDao {
    Command command;

    public DataDao(Command command) {
        this.command = command;
    }

    public void insert(){
        try {
            System.out.println("插入数据");
            command.execute();
        } catch (Exception e) {
            command.undo();
        }
    }
}

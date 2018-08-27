package org.sweetycode.designpattern.behavioral.command.transaction;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: TransactionalReceiver（接收者对象）：实现具体命令对应的业务方法。
 */
public class TransactionalReceiver {

    public void commit(){
        System.out.println("mysql 提交事务");
    }

    public void rollback(){
        System.out.println("mysql 回滚事务");
    }
}

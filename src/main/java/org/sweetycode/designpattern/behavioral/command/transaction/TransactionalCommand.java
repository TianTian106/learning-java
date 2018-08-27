package org.sweetycode.designpattern.behavioral.command.transaction;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: TransactionalCommand（具体命令对象）：它实现了抽象命令对象的方法，同时拥有一个命令接收者（TransactionalReceiver）的引用，在execut和undo方法中分别调用命令接收者的方法。
 */
public class TransactionalCommand implements Command {

    private TransactionalReceiver transactionalReceiver;

    public TransactionalCommand(TransactionalReceiver transactionalReceiver) {
        this.transactionalReceiver = transactionalReceiver;
    }

    @Override
    public void execute() {
        transactionalReceiver.commit();
        System.out.println("事务已提交");
    }

    @Override
    public void undo() {
        transactionalReceiver.rollback();
        System.out.println("事务已回滚");
    }
}

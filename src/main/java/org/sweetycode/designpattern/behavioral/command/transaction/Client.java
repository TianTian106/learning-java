package org.sweetycode.designpattern.behavioral.command.transaction;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: 命令模式：将一个请求封装为一个对象，可让请求变得灵活（请求对象参数化），同时将请求者和请求接收者解耦。比如，A对象想调用B对象的某个方法，那么A对象必然需要依赖B对象；使用命令模式的话就类似抽取出一个公共地方（请求对象），A依赖请求对象，A只需调用请求对象的方法，然后由请求对象调用B对象的方法，这样A和B就成功的解耦了。
 * 命令队列：当一个请求对应多个接收者时，可以使用命令对象形式来实现。就是增加一个命令队列的对象，请求调用者不在依赖请求对象，而是依赖于命令对象队列，命令对象队列中维护了一个保护抽象请求对象（命令对象）的集合，在命令对象队列中通过循环抽象命令集合进行接收者调用。
 * 撤销操作：在命令模式中，我们可以通过调用一个命令对象的execute()方法来实现对请求的处理，如果需要撤销(Undo)请求，可通过在命令类中增加一个逆向操作来实现。
 * Client（客户端测试）：
 */
public class Client {
    public static void main(String[] args) {
        //接收者对象
        TransactionalReceiver transactionalReceiver = new TransactionalReceiver();
        //命令对象（依赖接收者对象）
        TransactionalCommand transactionalCommand = new TransactionalCommand(transactionalReceiver);
        //调用者对象（依赖命令对象）
        DataDao dataDao = new DataDao(transactionalCommand);

        dataDao.insert();
    }
}

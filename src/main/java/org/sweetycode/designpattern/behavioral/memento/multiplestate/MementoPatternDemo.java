package org.sweetycode.designpattern.behavioral.memento.multiplestate;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: 多重检查点的备忘录模式。常见的系统往往需要存储不止一个状态，而是需要存储多个状态，或者叫做有多个检查点。
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker(originator);

        originator.setStates("State #1");
        careTaker.createMemento();
        originator.setStates("State #2");
        careTaker.createMemento();
        originator.setStates("State #3");
        careTaker.createMemento();

        System.out.println("-----------------打印出所有检查点-----------------");
        originator.printStates();
        System.out.println("-----------------恢复检查点-----------------");
        careTaker.restoreMemento(1);
        originator.printStates();
    }
}

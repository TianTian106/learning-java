package org.sweetycode.designpattern.behavioral.memento.singlestate.whitebox;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: 备忘录模式（Memento Pattern）、快照模式(Snapshot Pattern)或Token模式，保存一个对象的某个状态，以便在适当的时候恢复对象。
 * 在不破坏封装的条件下，将一个对象的状态捕捉(Capture)住，并外部化，存储起来，从而可以在将来合适的时候把这个对象还原到存储起来的状态。
 * Originator 创建并在 Memento 对象中存储状态。Caretaker 对象负责从 Memento 中恢复对象的状态。
 *
 * “白箱”备忘录
 * 备忘录角色对任何对象都提供一个接口，即宽接口，备忘录角色的内部所存储的状态就对所有对象公开。因此这个实现又叫做“白箱实现”。
 * “白箱”实现将发起人角色的状态存储在一个大家都看得到的地方，因此是破坏封装性的。但是通过程序员自律，同样可以在一定程度上实现模式的大部分用意。因此白箱实现仍然是有意义的。
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        // 修改发起人对象的状态
        originator.setState("State #1");
        // 创建备忘录对象，并将发起人对象的状态存储起来
        careTaker.add(originator.saveStateToMemento());
        // 修改发起人对象的状态
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        System.out.println("Current State: " + originator.getState());
        // 恢复发起人对象的状态
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());

    }
}

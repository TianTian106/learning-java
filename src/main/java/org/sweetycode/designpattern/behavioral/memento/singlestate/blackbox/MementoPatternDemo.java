package org.sweetycode.designpattern.behavioral.memento.singlestate.blackbox;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: “黑箱”备忘录模式的实现
 * 备忘录角色对发起人（Originator）角色对象提供一个宽接口，而为其他对象提供一个窄接口。这样的实现叫做“黑箱实现”。
 * 在JAVA语言中，实现双重接口的办法就是将备忘录角色类设计成发起人角色类的内部成员类。
 * 将Memento设成Originator类的内部类，从而将Memento对象封装在Originator里面；在外部提供一个标识接口MementoIF给Caretaker以及其他对象。这样，Originator类看到的是Menmento的所有接口，而Caretaker以及其他对象看到的仅仅是标识接口MementoIF所暴露出来的接口。
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        careTaker.add(originator.createMemento());
        originator.setState("State #2");
        careTaker.add(originator.createMemento());

        originator.restoreMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.restoreMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}

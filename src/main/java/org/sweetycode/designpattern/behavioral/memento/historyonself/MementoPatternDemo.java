package org.sweetycode.designpattern.behavioral.memento.historyonself;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: 在备忘录模式中，发起人(Originator)角色、负责人(Caretaker)角色和备忘录(Memento)角色都是独立的角色。虽然在实现上备忘录类可以成为发起人类的内部成员类，但是备忘录类仍然保持作为一个角色的独立意义。
 * 在“自述历史”模式里面，发起人角色自己兼任负责人角色。
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();

        originator.setState("State #1");
        MementoIF mementoIF = originator.createMemento();
        originator.setState("State #2");

        System.out.println("Current State: " + originator.getState());
        originator.restoreMemento(mementoIF);
        System.out.println("Memento State: " + originator.getState());
    }
}

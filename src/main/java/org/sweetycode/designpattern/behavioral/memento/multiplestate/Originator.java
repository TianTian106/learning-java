package org.sweetycode.designpattern.behavioral.memento.multiplestate;


import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description:
 */
public class Originator {
    private List<String> states;
    // 检查点指数
    private int index;

    public Originator() {
        this.states = new ArrayList<>();
        index = 0;
    }

    public Memento createMemento() {
        return new Memento(states, index);
    }

    public void restoreMemento(Memento memento) {
        states = memento.getStates();
        index = memento.getIndex();
    }

    /**
     * 状态的赋值方法
     */
    public void setStates(String state) {
        states.add(state);
        index ++ ;
    }

    public void printStates() {
        for (String state: states) {
            System.out.println(state);
        }
    }
}

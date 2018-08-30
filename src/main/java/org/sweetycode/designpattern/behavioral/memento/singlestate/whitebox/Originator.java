package org.sweetycode.designpattern.behavioral.memento.singlestate.whitebox;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: 发起人（Originator）角色，责任：
 * (1) 创建一个含有当前的内部状态的备忘录对象。
 * (2) 使用备忘录对象存储其内部状态。
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 工厂方法，返回一个新的备忘录对象
     */
    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    /**
     * 将发起人恢复到备忘录对象所记载的状态
     */
    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}

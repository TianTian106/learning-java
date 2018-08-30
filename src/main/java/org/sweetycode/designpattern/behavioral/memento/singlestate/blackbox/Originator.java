package org.sweetycode.designpattern.behavioral.memento.singlestate.blackbox;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description:
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
    public MementoIF createMemento() {
        return new Memento(state);
    }
    /**
     * 将发起人恢复到备忘录对象所记载的状态
     */
    public void restoreMemento(MementoIF mementoIF) {
        this.setState(((Memento)mementoIF).getState());
    }

    private class Memento implements MementoIF {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}

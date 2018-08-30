package org.sweetycode.designpattern.behavioral.memento.historyonself;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description:
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(this);
    }

    public void restoreMemento(MementoIF mementoIF) {
        setState(((Memento)mementoIF).state);
    }

    private class Memento implements MementoIF {
        private String state;

        public Memento(Originator originator) {
            this.state = originator.state;
        }

        public String getState() {
            return state;
        }
    }
}

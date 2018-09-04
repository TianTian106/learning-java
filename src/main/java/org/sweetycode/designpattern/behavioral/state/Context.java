package org.sweetycode.designpattern.behavioral.state;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

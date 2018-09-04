package org.sweetycode.designpattern.behavioral.state;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
    }

    public String toString() {
        return "Stop State";
    }
}

package org.sweetycode.designpattern.behavioral.state;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description: 状态模式（State Pattern），类的行为是基于它的状态改变的。
 * 通常命令模式的接口中只有一个方法。而状态模式的接口中有一个或者多个方法。
 * 状态模式和命令模式一样，也可以用于消除 if...else 等条件选择语句。
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        StopState stopState = new StopState();

        //System.out.println(context.getState().toString());
        startState.doAction(context);
        stopState.doAction(context);

        context.setState(startState);
        System.out.println(context.getState().toString());

        context.setState(stopState);
        System.out.println(context.getState().toString());
    }
}

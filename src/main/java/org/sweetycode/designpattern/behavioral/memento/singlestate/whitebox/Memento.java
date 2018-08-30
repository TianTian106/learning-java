package org.sweetycode.designpattern.behavioral.memento.singlestate.whitebox;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: 备忘录(Memento)角色：
 * (1) 将发起人（Originator）对象的内部状态存储起来。备忘录可以根据发起人对象的判断来决定存储多少发起人（Originator）对象的内部状态。
 * (2) 备忘录可以保护其内容不被发起人（Originator）对象之外的任何对象所读取。
 * 备忘录有两个等效的接口：
 * 窄接口：负责人（Caretaker）对象（和其他除发起人对象之外的任何对象）看到的是备忘录的窄接口(narrow interface)，这个窄接口只允许它把备忘录对象传给其他的对象。
 * 宽接口：与负责人对象看到的窄接口相反的是，发起人对象可以看到一个宽接口(wide interface)，这个宽接口允许它读取所有的数据，以便根据这些数据恢复这个发起人对象的内部状态。
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

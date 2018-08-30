package org.sweetycode.designpattern.behavioral.memento.singlestate.whitebox;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description: 负责人（Caretaker）角色，责任：
 * (1) 负责保存备忘录对象。
 * (2) 不检查备忘录对象的内容。
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    /**
     * 备忘录的赋值方法
     */
    public void add(Memento memento) {
        mementoList.add(memento);
    }

    /**
     * 备忘录的取值方法
     */
    public Memento get(int index) {
        return mementoList.get(index);
    }
}

package org.sweetycode.designpattern.behavioral.memento.singlestate.blackbox;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/30
 * @Description:
 */
public class CareTaker {
    private List<MementoIF> mementoIFList = new ArrayList<>();

    public void add(MementoIF mementoIF) {
        mementoIFList.add(mementoIF);
    }

    public MementoIF get(int index) {
        return mementoIFList.get(index);
    }
}

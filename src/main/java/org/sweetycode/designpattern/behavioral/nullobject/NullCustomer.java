package org.sweetycode.designpattern.behavioral.nullobject;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }
}

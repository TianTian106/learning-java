package org.sweetycode.designpattern.behavioral.nullobject;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public class RealCustomer extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}

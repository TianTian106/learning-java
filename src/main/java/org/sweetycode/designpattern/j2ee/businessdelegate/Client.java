package org.sweetycode.designpattern.j2ee.businessdelegate;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public class Client {
    BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void doTask() {
        businessDelegate.doTask();
    }
}

package org.sweetycode.designpattern.j2ee.servicelocator;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description:
 */
public class Service2 implements Service {
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service2");
    }
}

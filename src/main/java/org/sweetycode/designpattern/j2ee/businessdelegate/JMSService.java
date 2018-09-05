package org.sweetycode.designpattern.j2ee.businessdelegate;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public class JMSService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}

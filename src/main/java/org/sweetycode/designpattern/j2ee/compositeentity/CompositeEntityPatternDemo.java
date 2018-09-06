package org.sweetycode.designpattern.j2ee.compositeentity;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description:
 */
public class CompositeEntityPatternDemo {
    public static void main(String[] args) {
        Client client = new Client();

        client.setData("Test", "Data");
        client.printData();

        client.setData("Second Test", "Data1");
        client.printData();
    }
}

package org.sweetycode.designpattern.j2ee.compositeentity;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 使用组合实体的客户端类
 */
public class Client {
    private CompositeEntity compositeEntity = new CompositeEntity();

    public void printData() {
        for (String data : compositeEntity.getData()) {
            System.out.println("Data: " + data);
        }
    }

    public void setData(String data1, String data2) {
        compositeEntity.setData(data1, data2);
    }
}

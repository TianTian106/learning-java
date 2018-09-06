package org.sweetycode.designpattern.j2ee.compositeentity;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 依赖对象（Dependent Object） - 依赖对象是一个持续生命周期依赖于粗粒度对象的对象。
 */
public class DependentObject1 {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

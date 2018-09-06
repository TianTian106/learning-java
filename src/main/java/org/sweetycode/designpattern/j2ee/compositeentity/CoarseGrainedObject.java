package org.sweetycode.designpattern.j2ee.compositeentity;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 粗粒度对象（Coarse-Grained Object） - 该对象包含依赖对象。它有自己的生命周期，也能管理依赖对象的生命周期。
 */
public class CoarseGrainedObject {
    DependentObject1 dependentObject1 = new DependentObject1();
    DependentObject2 dependentObject2 = new DependentObject2();

    public void setData(String data1, String data2) {
        dependentObject1.setData(data1);
        dependentObject2.setData(data2);
    }

    public String[] getData() {
        return new String[] {dependentObject1.getData(), dependentObject2.getData()};
    }
}

package org.sweetycode.designpattern.j2ee.compositeentity;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 组合实体（Composite Entity） - 它是主要的实体 bean。它可以是粗粒的，或者可以包含一个粗粒度对象，用于持续生命周期。
 */
public class CompositeEntity {
    private CoarseGrainedObject coarseGrainedObject = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        coarseGrainedObject.setData(data1, data2);
    }

    public String[] getData() {
        return coarseGrainedObject.getData();
    }
}

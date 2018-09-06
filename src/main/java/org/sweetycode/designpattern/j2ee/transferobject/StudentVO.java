package org.sweetycode.designpattern.j2ee.transferobject;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 传输对象（Transfer Object） - 简单的 POJO，可序列化，只有设置/获取属性的方法。
 */
public class StudentVO {
    private String name;
    private int rollNo;

    public StudentVO(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}

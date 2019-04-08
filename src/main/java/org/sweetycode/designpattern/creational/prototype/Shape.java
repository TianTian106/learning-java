package org.sweetycode.designpattern.creational.prototype;

import java.io.*;

public abstract class Shape implements Cloneable,Serializable {
    // idea 安装GenerateSerialVersionUID插件
    // 设置Default Settings -> Inspections -> Serializable class without 'serialVersionUID'
    private static final long serialVersionUID = -8493456657505211132L;

    private String id;
    protected String type;
    private DeepAttr deepAttr = new DeepAttr("", 0);

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getDeepAttr() {
        return deepAttr.toString();
    }

    public void setDeepAttr(String name, Integer age) {
        //每次new肯定不行啊，你把原型的值改了，copy版的没改啊，相当于原型和copy被你强行换了不同的引用，
        //this.deepAttr = new DeepAttr(name, age);     //不能这样！
        this.deepAttr.setName(name);
        this.deepAttr.setAge(age);
    }

    // 浅拷贝
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    // 深拷贝
    public Object deepClone() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            /* 写入当前对象的二进制流 */
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        try {
            /* 读出二进制流产生的新对象 */
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

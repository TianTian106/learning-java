package org.sweetycode.designpattern.creational.prototype;

import java.io.Serializable;

public class DeepAttr implements Serializable{
    private String name;
    private Integer age;

    public DeepAttr(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "DeepAttr{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

package org.sweetycode.designpattern.creational.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        EagerSingleObject object = EagerSingleObject.getInstance();
        object.showMessage();
        EnumSingleObject.INSTANCE.sayID();
        System.out.println(EnumSingleObject.INSTANCE == EnumSingleObject.INSTANCE);
    }
}

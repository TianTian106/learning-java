package org.sweetycode.designpattern.creational.singleton;

public class LazySingleObject {
    //懒汉式单例模式
    //比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢
    private static LazySingleObject instance = null;
    private LazySingleObject() {}
    public static synchronized LazySingleObject getInstance(){
        if(instance == null) {
            instance = new LazySingleObject();
        }
        return instance;
    }
}

package org.sweetycode.designpattern.creational.singleton;

public class EagerSingleObject {
    //饿汉单例模式
    //在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快。基于 classloader 机制避免了多线程的同步问题
    private static EagerSingleObject instance = new EagerSingleObject();
    private EagerSingleObject(){}
    public static EagerSingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}

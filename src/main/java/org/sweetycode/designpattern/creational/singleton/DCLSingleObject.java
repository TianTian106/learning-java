package org.sweetycode.designpattern.creational.singleton;

//TODO:volatile https://www.cnblogs.com/dolphin0520/p/3920373.html
public class DCLSingleObject {
    //双检锁/双重校验锁 double-checked locking
    //采用双锁机制，安全且在多线程情况下能保持高性能。
    private volatile static DCLSingleObject instance; // volatile 禁止 JVM 的指令重排
    private DCLSingleObject() {}
    public static DCLSingleObject getInstance(){
        if(instance == null) {
            synchronized (DCLSingleObject.class){
                if(instance == null) {
                    instance = new DCLSingleObject();
                }
            }
        }
        return instance;
    }
}

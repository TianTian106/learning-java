package org.sweetycode.designpattern.creational.singleton;

public class SISingleObject {
    //静态内部类方法，是对饿汉式的改进，实现懒加载
    private static class SingletonHolder{
        private static final SISingleObject INSTANCE = new SISingleObject();
    }
    private SISingleObject(){}
    public static final SISingleObject getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

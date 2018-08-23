package org.sweetycode.designpattern.creational.singleton;

/**
 实现单例模式的最佳方法。更简洁，避免多线程同步问题，自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。
 不能通过 reflection attack 来调用私有构造方法。
 */
public enum EnumSingleObject {
    INSTANCE;
    private int id = 123;
    public void sayID(){
        System.out.println("ID is " + id);
    }
}

package org.sweetycode.designpattern.structural.proxy;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description: 代理模式（Proxy Pattern），一个类代表另一个类的功能。为其他对象提供一种代理以控制对这个对象的访问。
 * 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
 * 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        // 图像从磁盘加载
        image.display();
        System.out.println("");

        // 图像不从磁盘加载
        image.display();
    }
}

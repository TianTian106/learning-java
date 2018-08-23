package org.sweetycode.designpattern.structural.flyweight;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description: 享元模式与原型模式有异曲同工之妙，原型模式通过Clone的方式来重复利用已创建的对象，享元模式通过分离外部状态和内部状态来实现对象的复用，
 * 二者都能有效降低堆内存的占用的提高程序的性能。但原型模式核心在于克隆，而享元模式在于内部状态的共享，和独立的外部状态。
 */
public class FlyweightPatternDemo {
    // 内部状态为不变共享部分，存储于享元对象内部
    private static final String colors[] =
            { "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {

        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            // 外部状态是可变部分，由客户端负责
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}

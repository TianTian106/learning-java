package org.sweetycode.designpattern.structural.bridge;

/**
 * 定义：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 意图：将抽象与实现解耦。
 * 桥接模式主要应对的是由于实际的需要，某个类具有两个或者两个以上的维度变化（违反了SRP原则），如果只是用继承将无法实现这种需要，或者使得设计变得相当臃肿。
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new PaintRed());
        Shape greenCircle = new Circle(200, 200, 20, new PaintGreen());
        Shape circle = new Circle(300,300,30);

        redCircle.draw();
        redCircle.area();
        System.out.println();
        greenCircle.draw();
        greenCircle.area();
        System.out.println();
        circle.draw();
        circle.area();
    }
}

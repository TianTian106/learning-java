package org.sweetycode.designpattern.structural.decorator;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description: 装饰器模式（Decorator Pattern），动态地给一个对象添加一些额外的职责，可代替继承。
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

    }
}

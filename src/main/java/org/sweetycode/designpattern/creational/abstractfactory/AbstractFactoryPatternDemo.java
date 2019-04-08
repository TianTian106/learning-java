package org.sweetycode.designpattern.creational.abstractfactory;

/**
 * 抽象工厂模式中我们可以定义实现不止一个接口，一个工厂也可以生成不止一个产品类。
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("circle"); shape1.draw();
        Shape shape2 = shapeFactory.getShape("rectangle"); shape2.draw();
        Shape shape3 = shapeFactory.getShape("square"); shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("red"); color1.fill();
        Color color2 = colorFactory.getColor("green"); color2.fill();
        Color color3 = colorFactory.getColor("blue"); color3.fill();

    }
}

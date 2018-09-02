package org.sweetycode.designpattern.structural.decorator.shape;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description:
 */
public abstract class ShapeDecorator implements Shape {
    //持有一个形状对象接口
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}

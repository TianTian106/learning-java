package org.sweetycode.designpattern.structural.decorator.shape;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description:
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Boder Color: Red");
    }
}

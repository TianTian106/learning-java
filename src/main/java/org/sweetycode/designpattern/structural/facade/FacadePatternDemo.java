package org.sweetycode.designpattern.structural.facade;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description: 为子系统中的一组接口提供一个一致的界面，有选择性地暴露方法。
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

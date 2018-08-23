package org.sweetycode.designpattern.structural.facade;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description:
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

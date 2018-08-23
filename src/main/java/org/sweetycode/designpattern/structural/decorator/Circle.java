package org.sweetycode.designpattern.structural.decorator;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description:
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

package org.sweetycode.designpattern.structural.facade;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description:
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

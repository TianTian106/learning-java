package org.sweetycode.designpattern.creational.prototype;

public class Rectangle extends Shape {

    private static final long serialVersionUID = 1250152023353371359L;

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

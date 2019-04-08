package org.sweetycode.designpattern.creational.prototype;

public class Circle extends Shape {

    private static final long serialVersionUID = -8617203431651030631L;

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

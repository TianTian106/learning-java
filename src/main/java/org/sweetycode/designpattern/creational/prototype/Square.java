package org.sweetycode.designpattern.creational.prototype;

public class Square extends Shape {

    private static final long serialVersionUID = 788565466888287234L;

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

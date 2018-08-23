package org.sweetycode.designpattern.creational.abstractfactory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

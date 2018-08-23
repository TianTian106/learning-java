package org.sweetycode.designpattern.creational.abstractfactory;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside PaintGreen::fill() method.");
    }
}

package org.sweetycode.designpattern.structural.bridge;

public abstract class Shape {
    protected PaintAPI paintAPI;
    protected Shape(){}
    protected Shape(PaintAPI paintAPI){
        this.paintAPI = paintAPI;
    }

    public abstract void draw();
    public abstract void area();
}

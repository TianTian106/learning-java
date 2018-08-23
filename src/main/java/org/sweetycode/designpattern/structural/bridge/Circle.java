package org.sweetycode.designpattern.structural.bridge;

public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(int x, int y, int radius, PaintAPI paintAPI){
        super(paintAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(){
        System.out.print("Draw a " + this.toString() + " ");
        if(paintAPI != null) {
            System.out.print(" and ");
            paintAPI.paint();
        } else {
            System.out.println(" without any color");
        }
    }

    @Override
    public void area() {
        System.out.println("Area of " + this.toString() + " is " + 3.14 * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}

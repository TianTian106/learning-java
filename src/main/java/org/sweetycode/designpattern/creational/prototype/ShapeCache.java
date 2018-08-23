package org.sweetycode.designpattern.creational.prototype;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        return (Shape) shapeMap.get(shapeId).clone();
    }

    public static Shape getDeepCloneShape(String shapeId) {
        return (Shape) shapeMap.get(shapeId).deepClone();
    }

    /**
     * test
     */
    public static void changeAttr(){
        shapeMap.get("1").setDeepAttr("test1",6);
        shapeMap.get("2").setDeepAttr("test2",66);
        shapeMap.get("3").setDeepAttr("test3",666);
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1"); circle.setDeepAttr("cc", 10);
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2"); square.setDeepAttr("ss", 20);
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3"); rectangle.setDeepAttr("rr", 30);
        shapeMap.put(rectangle.getId(),rectangle);
    }
}

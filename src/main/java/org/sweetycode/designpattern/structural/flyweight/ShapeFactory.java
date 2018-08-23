package org.sweetycode.designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/22
 * @Description:
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color){
        Circle circle =(Circle)circleMap.get(color);

        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }

}

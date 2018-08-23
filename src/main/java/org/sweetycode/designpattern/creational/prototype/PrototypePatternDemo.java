package org.sweetycode.designpattern.creational.prototype;

import java.text.ParseException;

/**
 * 用于创建重复的对象，同时又能保证性能。
 */
public class PrototypePatternDemo {
    public static void main(String[] args) throws ParseException{
        ShapeCache.loadCache();

        Shape clonedShape1 = (Shape) ShapeCache.getShape("1");
        Shape deepClonedShape1 = (Shape) ShapeCache.getDeepCloneShape("1");

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        Shape deepClonedShape2 = (Shape) ShapeCache.getDeepCloneShape("2");

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        Shape deepClonedShape3 = (Shape) ShapeCache.getDeepCloneShape("3");

        // 浅拷贝会跟着变，而深拷贝不会变化
        ShapeCache.changeAttr();

        System.out.println(clonedShape1.getDeepAttr() + ": Shape: " + clonedShape1.getType() + ": " + clonedShape1.hashCode());
        System.out.println(deepClonedShape1.getDeepAttr() + ": Shape: " + deepClonedShape1.getType() + ": " + deepClonedShape1.hashCode());

        System.out.println(clonedShape2.getDeepAttr() + ": Shape: " + clonedShape2.getType() + ": " + clonedShape2.hashCode());
        System.out.println(deepClonedShape2.getDeepAttr() + ": Shape: " + deepClonedShape2.getType() + ": " + deepClonedShape2.hashCode());

        System.out.println(clonedShape3.getDeepAttr() + ": Shape: " + clonedShape3.getType() + ": " + clonedShape3.hashCode());
        System.out.println(deepClonedShape3.getDeepAttr() + ": Shape: " + deepClonedShape3.getType() + ": " + deepClonedShape3.hashCode());


    }
}

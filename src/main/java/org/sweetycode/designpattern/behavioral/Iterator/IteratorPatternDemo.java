package org.sweetycode.designpattern.behavioral.Iterator;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: 迭代器模式（Iterator Pattern）用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 * 优点： 1、它支持以不同的方式遍历一个聚合对象。 2、迭代器简化了聚合类。 3、在同一个聚合上可以有多个遍历。 4、在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 * 缺点：由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，类的个数成对增加，这在一定程度上增加了系统的复杂性。
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
            String name = (String)iter.next();
            System.out.println("Name: " + name);
        }
    }
}

package org.sweetycode.designpattern.structural.composite;

/**
 * 组合模式，就是在一个对象中包含其他对象，这些被包含的对象可能是终点对象（不再包含别的对象），也有可能是非终点对象（其内部还包含其他对象，或叫组对象），我们将对象称为节点，
 * 即一个根节点包含许多子节点，这些子节点有的不再包含子节点，而有的仍然包含子节点，以此类推。
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);
        
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        // print all staff 
        System.out.println(CEO);
        for (Employee headEmployee: CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee: headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }

    }
}

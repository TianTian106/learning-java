package org.sweetycode.designpattern.behavioral.visitor;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description: 访问者模式（Visitor Pattern），使用一个访问者类，改变了元素类的执行算法。通过这种方式，元素的执行算法可以随着访问者改变而改变。
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computerPart = new Computer();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}

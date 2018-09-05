package org.sweetycode.designpattern.behavioral.visitor;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public interface ComputerPartVisitor {
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);
    void visit(Computer computer);
}

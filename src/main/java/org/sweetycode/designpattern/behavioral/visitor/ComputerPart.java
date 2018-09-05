package org.sweetycode.designpattern.behavioral.visitor;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

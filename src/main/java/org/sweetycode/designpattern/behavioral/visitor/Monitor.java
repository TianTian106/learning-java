package org.sweetycode.designpattern.behavioral.visitor;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

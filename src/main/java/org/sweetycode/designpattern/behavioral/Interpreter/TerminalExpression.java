package org.sweetycode.designpattern.behavioral.Interpreter;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description:
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;
        }
        return false;
    }
}

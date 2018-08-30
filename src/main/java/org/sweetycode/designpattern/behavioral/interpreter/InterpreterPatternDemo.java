package org.sweetycode.designpattern.behavioral.interpreter;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: 解释器模式（Interpreter Pattern）提供了评估语言的语法或表达式的方式。实现了一个表达式接口，该接口解释一个特定的上下文。这种模式被用在 SQL 解析、符号处理引擎等。
 * 可利用场景比较少，JAVA 中如果碰到可以用 expression4J 代替。
 */
public class InterpreterPatternDemo {
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married woman? " + isMarriedWoman.interpret("Married Julie"));
    }
}

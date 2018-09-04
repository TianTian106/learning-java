package org.sweetycode.designpattern.behavioral.template;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description: 模板模式（Template Pattern），一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。
 * 为防止恶意操作，一般模板方法都加上 final 关键词。
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        game = new Football();
        game.play();
    }
}

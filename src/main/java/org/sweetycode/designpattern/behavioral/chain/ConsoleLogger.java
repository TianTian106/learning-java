package org.sweetycode.designpattern.behavioral.chain;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description:
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

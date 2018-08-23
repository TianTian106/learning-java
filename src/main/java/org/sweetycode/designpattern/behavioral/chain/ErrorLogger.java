package org.sweetycode.designpattern.behavioral.chain;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description:
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Consle::Logger: " + message);
    }
}

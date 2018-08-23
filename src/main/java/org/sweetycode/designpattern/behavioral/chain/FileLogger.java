package org.sweetycode.designpattern.behavioral.chain;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description:
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

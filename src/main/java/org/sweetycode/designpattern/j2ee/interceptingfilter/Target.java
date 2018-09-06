package org.sweetycode.designpattern.j2ee.interceptingfilter;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: Target - Target 对象是请求处理程序。
 */
public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}

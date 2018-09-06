package org.sweetycode.designpattern.j2ee.interceptingfilter;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 过滤器接口
 * 过滤器（Filter） - 过滤器在请求处理程序执行请求之前或之后，执行某些任务。
 */
public interface Filter {
    public void execute(String request);
}

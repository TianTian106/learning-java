package org.sweetycode.designpattern.j2ee.frontcontroller;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 前端控制器模式（Front Controller Pattern）是用来提供一个集中的请求处理机制，所有的请求都将由一个单一的处理程序处理。
 * 该处理程序可以做认证/授权/记录日志，或者跟踪请求，然后把请求传给相应的处理程序。
 */
public class FrontCotrollerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("Home");
        frontController.dispatchRequest("Student");
    }
}

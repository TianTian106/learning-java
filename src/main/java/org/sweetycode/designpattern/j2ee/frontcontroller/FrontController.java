package org.sweetycode.designpattern.j2ee.frontcontroller;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 前端控制器（Front Controller） - 处理应用程序所有类型请求的单个处理程序，应用程序可以是基于 web 的应用程序，也可以是基于桌面的应用程序。
 */
public class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);
        if(isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}

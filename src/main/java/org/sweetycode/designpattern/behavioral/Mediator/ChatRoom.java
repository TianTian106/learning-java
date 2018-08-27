package org.sweetycode.designpattern.behavioral.Mediator;

import java.util.Date;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description: 中介类
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}

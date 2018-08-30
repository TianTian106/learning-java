package org.sweetycode.designpattern.behavioral.mediator;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/27
 * @Description:
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}

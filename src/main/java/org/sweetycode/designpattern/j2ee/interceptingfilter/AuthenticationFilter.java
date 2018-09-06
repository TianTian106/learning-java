package org.sweetycode.designpattern.j2ee.interceptingfilter;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description:
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}

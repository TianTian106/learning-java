package org.sweetycode.designpattern.behavioral.nullobject;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public class CustomerFactory {
    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String givenName) {
        for (String name: names) {
            if(name.equalsIgnoreCase(givenName)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}

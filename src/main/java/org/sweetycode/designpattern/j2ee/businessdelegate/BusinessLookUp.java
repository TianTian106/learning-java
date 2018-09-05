package org.sweetycode.designpattern.j2ee.businessdelegate;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {
        if(serviceType.equalsIgnoreCase("ejb")) {
            return new EJBService();
        } else if (serviceType.equalsIgnoreCase("jms")) {
            return new JMSService();
        }
        return null;
    }
}

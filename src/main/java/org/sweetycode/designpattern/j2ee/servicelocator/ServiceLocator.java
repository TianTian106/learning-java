package org.sweetycode.designpattern.j2ee.servicelocator;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 服务定位器（Service Locator） - 服务定位器是通过 JNDI 查找和缓存服务来获取服务的单点接触。
 */
public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {
        Service service = cache.getServices(jndiName);
        if(service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        service = (Service) context.lookup(jndiName);
        cache.addService(service);
        return service;
    }
}

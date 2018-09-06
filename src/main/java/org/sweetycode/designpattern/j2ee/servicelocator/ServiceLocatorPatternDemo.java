package org.sweetycode.designpattern.j2ee.servicelocator;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 服务定位器模式（Service Locator Pattern）用在我们想使用 JNDI 查询定位各种服务的时候。
 * 考虑到为某个服务查找 JNDI 的代价很高，服务定位器模式充分利用了缓存技术。
 * 在首次请求某个服务时，服务定位器在 JNDI 中查找服务，并缓存该服务对象。
 * 当再次请求相同的服务时，服务定位器会在它的缓存中查找，这样可以在很大程度上提高应用程序的性能。
 */
public class ServiceLocatorPatternDemo {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
        service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
    }
}

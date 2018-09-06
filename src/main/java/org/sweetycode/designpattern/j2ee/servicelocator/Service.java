package org.sweetycode.designpattern.j2ee.servicelocator;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/6
 * @Description: 服务接口
 * 服务（Service） - 实际处理请求的服务。对这种服务的引用可以在 JNDI 服务器中查找到。
 */
public interface Service {
    public String getName();
    public void execute();
}

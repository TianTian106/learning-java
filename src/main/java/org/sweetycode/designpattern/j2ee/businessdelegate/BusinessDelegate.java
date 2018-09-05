package org.sweetycode.designpattern.j2ee.businessdelegate;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/5
 * @Description:
 */
public class BusinessDelegate {
    private BusinessLookUp lookUp = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = lookUp.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}

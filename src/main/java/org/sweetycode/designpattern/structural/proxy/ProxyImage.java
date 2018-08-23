package org.sweetycode.designpattern.structural.proxy;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/23
 * @Description:
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

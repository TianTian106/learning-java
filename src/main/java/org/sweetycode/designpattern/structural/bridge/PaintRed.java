package org.sweetycode.designpattern.structural.bridge;

public class PaintRed implements PaintAPI {
    @Override
    public void paint() {
        System.out.println("paint it Red!");
    }
}

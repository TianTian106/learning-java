package org.sweetycode.designpattern.structural.bridge;

public class PaintGreen implements PaintAPI {
    @Override
    public void paint() {
        System.out.println("paint it Green!");
    }
}

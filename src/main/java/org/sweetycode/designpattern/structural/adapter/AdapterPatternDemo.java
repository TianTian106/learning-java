package org.sweetycode.designpattern.structural.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // 作为两个不兼容的接口之间的桥梁。
        // 适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。
        AudioPlayter audioPlayter = new AudioPlayter();

        audioPlayter.play("mp3", "Despacito.mp3");
        audioPlayter.play("mp4", "Lemon.mp4");
        audioPlayter.play("vlc", "Jeux d'enfants.vlc");
        audioPlayter.play("avi", "Loveless.avi");
    }
}

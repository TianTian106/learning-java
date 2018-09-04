package org.sweetycode.designpattern.behavioral.template;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // 为防止恶意操作，模板方法被设置为 final
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

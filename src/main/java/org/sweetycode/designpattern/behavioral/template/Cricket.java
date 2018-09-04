package org.sweetycode.designpattern.behavioral.template;

/**
 * @Auther: sweetycode
 * @Date: 2018/9/4
 * @Description:
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

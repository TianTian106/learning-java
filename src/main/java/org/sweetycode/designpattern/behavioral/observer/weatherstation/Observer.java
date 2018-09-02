package org.sweetycode.designpattern.behavioral.observer.weatherstation;

/**
 * Created by tiantian on 02/09/2018.
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}

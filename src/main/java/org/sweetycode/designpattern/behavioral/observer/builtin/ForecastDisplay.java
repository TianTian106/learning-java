package org.sweetycode.designpattern.behavioral.observer.builtin;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by tiantian on 02/09/2018.
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
        }

    }

    @Override
    public void display() {

    }
}

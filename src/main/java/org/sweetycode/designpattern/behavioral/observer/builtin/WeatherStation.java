package org.sweetycode.designpattern.behavioral.observer.builtin;

/**
 * Created by tiantian on 02/09/2018.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);

        weatherData.deleteObserver(currentConditionsDisplay);

        weatherData.setMeasurements(78, 90, 29.2f);
    }
}

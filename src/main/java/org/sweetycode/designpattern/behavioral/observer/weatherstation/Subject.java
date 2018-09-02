package org.sweetycode.designpattern.behavioral.observer.weatherstation;

/**
 * Created by tiantian on 02/09/2018.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

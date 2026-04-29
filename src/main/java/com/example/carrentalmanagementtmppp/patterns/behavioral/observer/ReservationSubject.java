package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationSubject {

    private final List<ReservationObserver> observers = new ArrayList<>();

    public void addObserver(ReservationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ReservationObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String eventType, Reservation reservation) {
        for (ReservationObserver observer : observers) {
            observer.update(eventType, reservation);
        }
    }
}

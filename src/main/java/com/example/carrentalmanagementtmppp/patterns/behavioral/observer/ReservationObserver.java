package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;

public interface ReservationObserver {
    void update(String eventType, Reservation reservation);
}

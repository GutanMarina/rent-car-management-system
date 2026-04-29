package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener implements ReservationObserver {

    @Override
    public void update(String eventType, Reservation reservation) {
        System.out.println("AUDIT LOG -> Reservation " + reservation.getId()
                + " changed state to " + reservation.getStatus()
                + " | event: " + eventType);
    }
}

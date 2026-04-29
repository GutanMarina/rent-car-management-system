package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.creational.factory.EmailNotificationFactory;
import com.example.carrentalmanagementtmppp.patterns.creational.factory.Notification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener implements ReservationObserver {

    private final EmailNotificationFactory emailNotificationFactory;

    public EmailNotificationListener(EmailNotificationFactory emailNotificationFactory) {
        this.emailNotificationFactory = emailNotificationFactory;
    }

    @Override
    public void update(String eventType, Reservation reservation) {
        Notification notification = emailNotificationFactory.createNotification();
        String message = "Reservation " + reservation.getId() + " event: " + eventType;
        notification.send(reservation.getUser().getEmail(), message);
    }
}
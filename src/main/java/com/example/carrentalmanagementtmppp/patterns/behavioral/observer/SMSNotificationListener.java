package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.creational.factory.Notification;
import com.example.carrentalmanagementtmppp.patterns.creational.factory.SMSNotificationFactory;
import org.springframework.stereotype.Component;


@Component
public class SMSNotificationListener implements ReservationObserver {

    private final SMSNotificationFactory smsNotificationFactory;

    public SMSNotificationListener(SMSNotificationFactory smsNotificationFactory) {
        this.smsNotificationFactory = smsNotificationFactory;
    }

    @Override
    public void update(String eventType, Reservation reservation) {
        Notification notification = smsNotificationFactory.createNotification();
        String message = "Reservation " + reservation.getId() + " event: " + eventType;
        notification.send(reservation.getUser().getPhone(), message);
    }
}
package com.example.carrentalmanagementtmppp.patterns.creational.factory;

import org.springframework.stereotype.Component;

@Component
public class SMSNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
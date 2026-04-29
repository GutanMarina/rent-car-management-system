package com.example.carrentalmanagementtmppp.patterns.creational.factory;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
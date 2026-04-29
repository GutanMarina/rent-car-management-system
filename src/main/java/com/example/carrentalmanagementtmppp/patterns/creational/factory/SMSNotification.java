package com.example.carrentalmanagementtmppp.patterns.creational.factory;

public class SMSNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }
}
package com.example.carrentalmanagementtmppp.patterns.creational.factory;

public class EmailNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("EMAIL sent to " + recipient + ": " + message);
    }
}
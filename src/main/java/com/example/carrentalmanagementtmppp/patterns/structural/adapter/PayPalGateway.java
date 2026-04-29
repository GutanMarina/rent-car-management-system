package com.example.carrentalmanagementtmppp.patterns.structural.adapter;

public class PayPalGateway {

    public boolean makePayment(double value) {
        System.out.println("PayPal gateway processed payment: " + value);
        return true;
    }
}

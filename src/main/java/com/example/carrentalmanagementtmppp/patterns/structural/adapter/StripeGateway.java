package com.example.carrentalmanagementtmppp.patterns.structural.adapter;

public class StripeGateway {

    public boolean pay(double amount) {
        System.out.println("Stripe gateway processed payment: " + amount);
        return true;
    }
}
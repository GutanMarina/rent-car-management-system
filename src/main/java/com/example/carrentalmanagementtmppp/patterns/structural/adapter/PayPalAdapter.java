package com.example.carrentalmanagementtmppp.patterns.structural.adapter;

public class PayPalAdapter implements PaymentProcessor {

    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public boolean processPayment(double amount) {
        return payPalGateway.makePayment(amount);
    }
}
package com.example.carrentalmanagementtmppp.patterns.structural.adapter;

public class StripeAdapter implements PaymentProcessor {

    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public boolean processPayment(double amount) {
        return stripeGateway.pay(amount);
    }
}

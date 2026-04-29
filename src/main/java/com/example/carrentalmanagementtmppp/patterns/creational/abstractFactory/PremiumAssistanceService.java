package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class PremiumAssistanceService implements AssistanceService {

    @Override
    public String getSupportLevel() {
        return "Premium 24/7 support";
    }
}

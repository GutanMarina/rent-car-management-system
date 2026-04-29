package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class StandardAssistanceService implements AssistanceService {

    @Override
    public String getSupportLevel() {
        return "Standard support";
    }
}

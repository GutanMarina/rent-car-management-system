package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class StandardPackageBenefits implements PackageBenefits {

    @Override
    public boolean hasIncludedGps() {
        return false;
    }

    @Override
    public boolean hasIncludedInsurance() {
        return false;
    }

    @Override
    public String getBenefitsDescription() {
        return "Standard package benefits";
    }
}

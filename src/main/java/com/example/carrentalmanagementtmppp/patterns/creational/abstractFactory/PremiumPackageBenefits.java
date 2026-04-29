package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class PremiumPackageBenefits implements PackageBenefits {

    @Override
    public boolean hasIncludedGps() {
        return true;
    }

    @Override
    public boolean hasIncludedInsurance() {
        return true;
    }

    @Override
    public String getBenefitsDescription() {
        return "Premium package benefits: included GPS and Insurance";
    }
}

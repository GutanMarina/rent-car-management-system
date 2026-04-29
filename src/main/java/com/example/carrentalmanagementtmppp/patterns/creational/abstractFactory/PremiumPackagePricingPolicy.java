package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class PremiumPackagePricingPolicy implements PackagePricingPolicy {

    @Override
    public double applyPackagePrice(double currentPrice) {
        return currentPrice * 1.10;
    }
}

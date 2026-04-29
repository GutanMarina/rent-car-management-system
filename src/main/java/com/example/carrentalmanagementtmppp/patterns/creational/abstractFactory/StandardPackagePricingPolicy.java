package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class StandardPackagePricingPolicy implements PackagePricingPolicy {

    @Override
    public double applyPackagePrice(double currentPrice) {
        return currentPrice;
    }
}

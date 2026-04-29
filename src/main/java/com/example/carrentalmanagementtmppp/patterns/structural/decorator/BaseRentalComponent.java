package com.example.carrentalmanagementtmppp.patterns.structural.decorator;

public class BaseRentalComponent implements RentalComponent {

    private final double baseCost;

    public BaseRentalComponent(double baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public double getCost() {
        return baseCost;
    }

    @Override
    public String getDescription() {
        return "Base rental";
    }
}

package com.example.carrentalmanagementtmppp.patterns.structural.decorator;

public class GPSDecorator extends RentalDecorator {

    public GPSDecorator(RentalComponent rentalComponent) {
        super(rentalComponent);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", GPS";
    }
}
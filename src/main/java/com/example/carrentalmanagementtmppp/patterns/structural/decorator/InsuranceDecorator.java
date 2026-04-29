package com.example.carrentalmanagementtmppp.patterns.structural.decorator;

public class InsuranceDecorator extends RentalDecorator {

    public InsuranceDecorator(RentalComponent rentalComponent) {
        super(rentalComponent);
    }

    @Override
    public double getCost() {
        return super.getCost() + 25.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Insurance";
    }
}

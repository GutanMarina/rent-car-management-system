package com.example.carrentalmanagementtmppp.patterns.structural.decorator;

public class ChildSeatDecorator extends RentalDecorator {

    public ChildSeatDecorator(RentalComponent rentalComponent) {
        super(rentalComponent);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Child Seat";
    }
}

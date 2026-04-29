package com.example.carrentalmanagementtmppp.patterns.structural.decorator;

public abstract class RentalDecorator implements RentalComponent {

    protected final RentalComponent rentalComponent;

    public RentalDecorator(RentalComponent rentalComponent) {
        this.rentalComponent = rentalComponent;
    }

    @Override
    public double getCost() {
        return rentalComponent.getCost();
    }

    @Override
    public String getDescription() {
        return rentalComponent.getDescription();
    }
}

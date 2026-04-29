package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public interface RentalPackageFactory {
    PackagePricingPolicy createPricingPolicy();
    PackageBenefits createBenefits();
    AssistanceService createAssistanceService();
}

package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class PremiumRentalPackageFactory implements RentalPackageFactory {

    @Override
    public PackagePricingPolicy createPricingPolicy() {
        return new PremiumPackagePricingPolicy();
    }

    @Override
    public PackageBenefits createBenefits() {
        return new PremiumPackageBenefits();
    }

    @Override
    public AssistanceService createAssistanceService() {
        return new PremiumAssistanceService();
    }
}

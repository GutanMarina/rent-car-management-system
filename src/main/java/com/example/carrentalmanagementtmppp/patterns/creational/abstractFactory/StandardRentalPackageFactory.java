package com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory;

public class StandardRentalPackageFactory implements RentalPackageFactory {

    @Override
    public PackagePricingPolicy createPricingPolicy() {
        return new StandardPackagePricingPolicy();
    }

    @Override
    public PackageBenefits createBenefits() {
        return new StandardPackageBenefits();
    }

    @Override
    public AssistanceService createAssistanceService() {
        return new StandardAssistanceService();
    }
}

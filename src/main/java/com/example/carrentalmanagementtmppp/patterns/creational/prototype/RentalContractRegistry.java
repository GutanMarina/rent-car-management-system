package com.example.carrentalmanagementtmppp.patterns.creational.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RentalContractRegistry {

    private final Map<String, RentalContract> templates = new HashMap<>();

    @PostConstruct
    public void init() {
        RentalContract standardTemplate = new RentalContract();
        standardTemplate.setTitle("Standard Rental Contract");
        standardTemplate.setStandardTerms("The vehicle must be returned in good condition. The renter is responsible for traffic fines and fuel policy compliance.");
        standardTemplate.setAdditionalNotes("Default contract template");
        templates.put("STANDARD", standardTemplate);

        RentalContract premiumTemplate = new RentalContract();
        premiumTemplate.setTitle("Premium Rental Contract");
        premiumTemplate.setStandardTerms("The vehicle must be returned in good condition. Premium support is included. Insurance and additional assistance clauses apply.");
        premiumTemplate.setAdditionalNotes("Premium contract template");
        templates.put("PREMIUM", premiumTemplate);
    }

    public RentalContract getTemplate(String type) {
        RentalContract template = templates.get(type.toUpperCase());
        if (template == null) {
            throw new RuntimeException("Contract template not found");
        }
        return (RentalContract) template.cloneContract();
    }
}

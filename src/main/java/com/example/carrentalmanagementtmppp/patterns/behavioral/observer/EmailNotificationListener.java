package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.creational.factory.EmailNotificationFactory;
import com.example.carrentalmanagementtmppp.patterns.creational.factory.Notification;
import org.springframework.stereotype.Component;

import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.service.EmailService;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener implements ReservationObserver {

    private final EmailService emailService;

    public EmailNotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void update(String eventType, Reservation reservation) {

        String email = reservation.getUser().getEmail();

        String subject = "RentCar Reservation Update";

        String text = """
                Hello %s,

                Your reservation #%d for %s has been updated.

                Event: %s
                Status: %s

                Pickup location: %s
                Total price: %.2f €

                Thank you for using RentCar.
                """.formatted(
                reservation.getUser().getFullName(),
                reservation.getId(),
                reservation.getCar().getBrand() + " " + reservation.getCar().getModel(),
                eventType,
                reservation.getStatus(),
                reservation.getPickupLocation(),
                reservation.getTotalPrice()
        );

        emailService.sendEmail(email, subject, text);

        System.out.println("REAL EMAIL sent to " + email);
    }
}
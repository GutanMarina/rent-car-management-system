package com.example.carrentalmanagementtmppp.config;

import com.example.carrentalmanagementtmppp.patterns.behavioral.observer.AuditLogListener;
import com.example.carrentalmanagementtmppp.patterns.behavioral.observer.EmailNotificationListener;
import com.example.carrentalmanagementtmppp.patterns.behavioral.observer.ReservationSubject;
import com.example.carrentalmanagementtmppp.patterns.behavioral.observer.SMSNotificationListener;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {

    private final ReservationSubject reservationSubject;
    private final EmailNotificationListener emailNotificationListener;
    private final SMSNotificationListener smsNotificationListener;
    private final AuditLogListener auditLogListener;

    public ObserverConfig(ReservationSubject reservationSubject,
                          EmailNotificationListener emailNotificationListener,
                          SMSNotificationListener smsNotificationListener,
                          AuditLogListener auditLogListener) {
        this.reservationSubject = reservationSubject;
        this.emailNotificationListener = emailNotificationListener;
        this.smsNotificationListener = smsNotificationListener;
        this.auditLogListener = auditLogListener;
    }

    @PostConstruct
    public void initObservers() {
        reservationSubject.addObserver(emailNotificationListener);
        reservationSubject.addObserver(smsNotificationListener);
        reservationSubject.addObserver(auditLogListener);
    }
}
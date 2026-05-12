package com.example.carrentalmanagementtmppp.patterns.behavioral.observer;

import com.example.carrentalmanagementtmppp.model.Reservation;
import org.springframework.stereotype.Component;

import com.example.carrentalmanagementtmppp.model.AuditLog;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.repository.AuditLogRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditLogListener implements ReservationObserver {

    private final AuditLogRepository auditLogRepository;

    public AuditLogListener(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public void update(String eventType, Reservation reservation) {
        AuditLog auditLog = AuditLog.builder()
                .reservationId(reservation.getId())
                .eventType(eventType)
                .reservationStatus(reservation.getStatus().name())
                .userEmail(reservation.getUser().getEmail())
                .message("Reservation " + reservation.getId()
                        + " changed state to " + reservation.getStatus()
                        + " | event: " + eventType)
                .createdAt(LocalDateTime.now())
                .build();

        auditLogRepository.save(auditLog);

        System.out.println("AUDIT LOG saved -> " + auditLog.getMessage());
    }
}

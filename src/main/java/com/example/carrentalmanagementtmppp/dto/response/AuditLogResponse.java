package com.example.carrentalmanagementtmppp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AuditLogResponse {

    private Long id;
    private Long reservationId;
    private String eventType;
    private String reservationStatus;
    private String userEmail;
    private String message;
    private LocalDateTime createdAt;
}
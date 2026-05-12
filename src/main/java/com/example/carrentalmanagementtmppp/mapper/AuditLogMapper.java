package com.example.carrentalmanagementtmppp.mapper;

import com.example.carrentalmanagementtmppp.dto.response.AuditLogResponse;
import com.example.carrentalmanagementtmppp.model.AuditLog;

public class AuditLogMapper {

    private AuditLogMapper() {
    }

    public static AuditLogResponse toResponse(AuditLog auditLog) {
        return new AuditLogResponse(
                auditLog.getId(),
                auditLog.getReservationId(),
                auditLog.getEventType(),
                auditLog.getReservationStatus(),
                auditLog.getUserEmail(),
                auditLog.getMessage(),
                auditLog.getCreatedAt()
        );
    }
}
package com.example.carrentalmanagementtmppp.service.impl;

import com.example.carrentalmanagementtmppp.model.AuditLog;
import com.example.carrentalmanagementtmppp.repository.AuditLogRepository;
import com.example.carrentalmanagementtmppp.service.AuditLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }
}

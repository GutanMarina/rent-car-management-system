package com.example.carrentalmanagementtmppp.service;

import com.example.carrentalmanagementtmppp.model.AuditLog;

import java.util.List;

public interface AuditLogService {
    List<AuditLog> getAllAuditLogs();
}
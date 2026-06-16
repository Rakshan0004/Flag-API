package com.example.featureflag.repository;

import com.example.featureflag.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    
    // Automatically orders the audit logs so the newest changes are first!
    List<AuditLog> findByFlagIdOrderByChangedAtDesc(Long flagId);
}

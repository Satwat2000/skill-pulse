package com.webkraft.skillpulse.base.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuditableEntity extends BaseEnitity {
    @Column(name = "updated_at", nullable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
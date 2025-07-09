package com.webkraft.skillpulse.entity;

import com.webkraft.skillpulse.base.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tags", schema = "sp_content")
public class Tag extends AuditableEntity {

    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_type", nullable = false)
    private String resourceType;

    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name="value", nullable = false)
    private String value;
}
package com.webkraft.skillpulse.entity;

import com.webkraft.skillpulse.base.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "resource_mappings", schema = "sp_content")
public class ResourceMapping extends AuditableEntity {

    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_type", nullable = false)
    private String resourceType;

    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name = "grade_id", nullable = false)
    private Long gradeId;

    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    @Column(name = "topic_id", nullable = false)
    private Long topicId;
}
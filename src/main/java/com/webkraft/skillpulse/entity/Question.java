package com.webkraft.skillpulse.entity;

import com.webkraft.skillpulse.base.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="questions", schema="sp_content")
public class Question extends AuditableEntity {

    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="question", nullable = false)
    private String question;

    @Column(name="type", nullable = false)
    private String type;
}

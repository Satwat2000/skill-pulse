package com.webkraft.skillpulse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "grades", schema = "eds_content")
public class Grade extends AuditableEntity {
    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="code", nullable = false, unique = true)
    private String code;

    @Column(name="sort",nullable = false)
    private Integer sort;
}
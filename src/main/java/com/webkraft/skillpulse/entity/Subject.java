package com.webkraft.skillpulse.entity;

import com.webkraft.skillpulse.base.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="subjects", schema="sp_content")
public class Subject extends AuditableEntity{

    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="code")
    private String code;

    @Column(name="sort", nullable = false)
    private int sort;
}
package com.webkraft.skillpulse.entity;


import com.webkraft.skillpulse.base.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="options", schema="sp_content")
public class Option extends AuditableEntity {
    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="option_text", nullable = false)
    private String optionText;

    @Column(name="media_link", nullable = false)
    private String mediaLink;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name="is_correct", nullable = false)
    private Boolean isCorrect;

    @Column(name="question_id", nullable = false)
    private Long questionId;
}

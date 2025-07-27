package com.webkraft.skillpulse.entity;

import com.webkraft.skillpulse.base.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "question_mappings", schema = "sp_content")
public class QuestionMapping extends AuditableEntity {

    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id", nullable = false)
    private Integer questionId;

    @Column(name = "grade_id", nullable = false)
    private Integer gradeId;

    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    @Column(name = "topic_id", nullable = false)
    private Integer topicId;
}

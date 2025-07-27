package com.webkraft.skillpulse.repository;

import com.webkraft.skillpulse.entity.Option;
import com.webkraft.skillpulse.entity.Question;
import com.webkraft.skillpulse.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface QuizRepository extends JpaRepository<Quiz, UUID> {

    @Query("SELECT q FROM QuestionMapping qm " +
            "JOIN Question q ON qm.questionId = q.id " +
            "JOIN Option o ON o.questionId = q.id " +
            "WHERE qm.subjectId = :subjectId " +
            "AND qm.gradeId = :gradeId " +
            "AND qm.topicId = :topicId")
    List<Question> fetchQuestionsFilterBy(@Param("subjectId") Integer subjectId,
                                  @Param("gradeId") Integer gradeId,
                                  @Param("topicId") Integer topicId);

    @Query("SELECT q FROM QuestionMapping qm " +
            "JOIN Question q ON qm.questionId = q.id " +
            "JOIN Option o ON o.questionId = q.id " +
            "WHERE qm.subjectId = :subjectId " +
            "AND qm.gradeId = :gradeId ")
    List<Question> fetchQuestionsFilterBy(@Param("subjectId") Integer subjectId,
                                          @Param("gradeId") Integer gradeId);

    @Query("SELECT q FROM QuestionMapping qm " +
            "JOIN Question q ON qm.questionId = q.id " +
            "JOIN Option o ON o.questionId = q.id " +
            "WHERE qm.subjectId = :subjectId ")
    List<Question> fetchQuestionsFilterBy(@Param("subjectId") Integer subjectId);

    @Query("SELECT q FROM Question q")
    List<Question> fetchAllQuestions();

    @Query("SELECT o FROM Option o WHERE o.questionId = :questionId")
    List<Option> fetchOptions(@Param("questionId") Integer questionId);

}



package com.webkraft.skillpulse.dto.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
    private UUID quizId;
    private List<QuestionDto> mappedQuestion;
}

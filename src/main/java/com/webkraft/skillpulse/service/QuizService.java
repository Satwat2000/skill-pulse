package com.webkraft.skillpulse.service;

import com.webkraft.skillpulse.dto.content.QuestionDto;
import java.util.List;

public interface QuizService {
    List<QuestionDto> getAllQuestion();
}

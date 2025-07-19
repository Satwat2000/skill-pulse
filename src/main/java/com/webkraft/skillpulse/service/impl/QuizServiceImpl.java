package com.webkraft.skillpulse.service.impl;

import com.webkraft.skillpulse.dto.content.QuestionDto;
import com.webkraft.skillpulse.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Override
    public List<QuestionDto> getAllQuestion(){
        List<QuestionDto> questionList = new ArrayList<>();
        return questionList;
    }
}

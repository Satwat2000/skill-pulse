package com.webkraft.skillpulse.service.impl;

import com.webkraft.skillpulse.dto.content.QuestionDto;
import com.webkraft.skillpulse.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Override
    public List<QuestionDto> getAllQuestion(){
        List<QuestionDto> questionList = new ArrayList<>();
        return questionList;
    }
}

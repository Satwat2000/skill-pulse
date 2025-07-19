package com.webkraft.skillpulse.controller;


import com.webkraft.skillpulse.dto.content.QuestionDto;
import com.webkraft.skillpulse.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("all-questions")
    public List<QuestionDto> fetchAllQuestions(){
        return quizService.getAllQuestion();
    }
}

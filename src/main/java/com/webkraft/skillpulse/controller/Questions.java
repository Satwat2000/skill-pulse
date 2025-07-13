package com.webkraft.skillpulse.controller;


import com.webkraft.skillpulse.dto.content.QuestionDto;
import com.webkraft.skillpulse.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class Questions {

    @Autowired
    QuestionService questionService;

    @GetMapping("all-questions")
    public List<QuestionDto> fetchAllQuestions(){
        return questionService.getAllQuestion();
    }


}

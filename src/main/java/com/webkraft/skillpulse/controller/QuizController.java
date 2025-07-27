package com.webkraft.skillpulse.controller;


import com.webkraft.skillpulse.dto.content.QuestionDto;
import com.webkraft.skillpulse.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("all-questions")
    public ResponseEntity<List<QuestionDto>> fetchAllQuestions(@RequestParam(required = false) Integer subjectId,
                                                               @RequestParam(required = false) Integer gradeId,
                                                               @RequestParam(required = false) Integer topicId)
    {
        List<QuestionDto> data = quizService.getAllQuestion(subjectId, gradeId, topicId);
        return ResponseEntity.ok(data);
    }
}

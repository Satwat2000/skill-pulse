package com.webkraft.skillpulse.service.impl;

import com.webkraft.skillpulse.dto.content.OptionDto;
import com.webkraft.skillpulse.dto.content.QuestionDto;
import com.webkraft.skillpulse.entity.Option;
import com.webkraft.skillpulse.entity.Question;
import com.webkraft.skillpulse.repository.QuizRepository;
import com.webkraft.skillpulse.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepo;

    public List<QuestionDto> getAllQuestion(Integer subjectId, Integer gradeId, Integer topicId) {

        List<QuestionDto> res = new ArrayList<>();

        List<Question> questionList = fetchFilterdQuestions(subjectId, gradeId, topicId);

        for(var question : questionList){
            int questionId = question.getId();
            QuestionDto questionDto = QuestionDto.builder()
                    .questionId(questionId)
                    .questionText(question.getQuestion())
                    .questionType(question.getType())
                    .build();
            List<Option> optionList = this.quizRepo.fetchOptions(questionId);
            List<OptionDto> optionDtoList = new ArrayList<>();
            for (Option option : optionList){
                OptionDto optionDto = OptionDto.builder()
                        .optionId(option.getId())
                        .optionText(option.getOptionText())
                        .mediaLink(option.getMediaLink())
                        .type(option.getType())
                        .isCorrect(option.getIsCorrect())
                        .build();
                optionDtoList.add(optionDto);
            }
            questionDto.setOptions(optionDtoList);
            res.add(questionDto);
        }
        return res;
    }

    private List<Question> fetchFilterdQuestions(Integer subjectId, Integer gradeId, Integer topicId){
        if(subjectId != null && gradeId != null && topicId != null) {
            return this.quizRepo.fetchQuestionsFilterBy(subjectId, gradeId, topicId);
        }
        else if (subjectId !=null  && gradeId != null){
           return this.quizRepo.fetchQuestionsFilterBy(subjectId, gradeId);
        }
        else if(subjectId != null){
            return this.quizRepo.fetchQuestionsFilterBy(subjectId);
        }
        else {
            return this.quizRepo.fetchAllQuestions();
        }
    }
}

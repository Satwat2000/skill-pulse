package com.webkraft.skillpulse.dto.content;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Integer questionId;
    private String questionText;
    private String questionType;
    private List<OptionDto> options;
}

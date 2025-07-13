package com.webkraft.skillpulse.dto.content;

import lombok.Data;

@Data
public class OptionDto {
    private Integer optionId;
    private String optionText;
    private String mediaLink;
    private String type;
    private Boolean isCorrect;
}

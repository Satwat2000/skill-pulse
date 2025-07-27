package com.webkraft.skillpulse.dto.content;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionDto {
    private Integer optionId;
    private String optionText;
    private String mediaLink;
    private String type;
    private Boolean isCorrect;
}

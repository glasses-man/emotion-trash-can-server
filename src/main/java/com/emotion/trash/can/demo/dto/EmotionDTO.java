package com.emotion.trash.can.demo.dto;

import lombok.*;

import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmotionDTO {
    private Long id;
    private String content;
    private Long fkPostId;
}

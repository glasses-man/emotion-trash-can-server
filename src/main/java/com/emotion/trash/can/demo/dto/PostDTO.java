package com.emotion.trash.can.demo.dto;

import com.emotion.trash.can.demo.entity.EmotionEntity;
import com.emotion.trash.can.demo.entity.PostEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime regDate, modDate;
    private List<String> emotion;
    
}

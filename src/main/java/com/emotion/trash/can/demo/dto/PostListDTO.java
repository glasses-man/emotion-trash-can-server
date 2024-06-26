package com.emotion.trash.can.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostListDTO {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime regDate, modDate;

}

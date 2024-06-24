package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.EmotionDTO;
import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.entity.PostEntity;

public interface PostService {
    Long register(PostDTO dto);

    void modify(PostDTO dto);

    void emotionModify(EmotionDTO dto);

    default PostEntity dtoToEntity(PostDTO dto) {
        PostEntity entity = PostEntity.builder()
                .postId(dto.getPostId())
                .title(dto.getTitle())
                .userName(dto.getUserName())
                .content(dto.getContent())
                .build();
        return entity;
    }

    default PostDTO entityToDto(PostEntity entity) {
        PostDTO dto = PostDTO.builder()
                .postId(entity.getPostId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .userName(entity.getUserName())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}

package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.entity.PostEntity;

public interface PostService {
    Long register(PostDTO dto);

    void modify(PostDTO dto);


    default PostEntity dtoToEntity(PostDTO dto) {
        PostEntity entity = PostEntity.builder()
                .postId(dto.getPostId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .userName(dto.getUserName())
                .build();
        return entity;
    }

    default PostDTO entityToDto(PostEntity entity) {
        PostDTO dto = PostDTO.builder()
                .postId(entity.getPostId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .userName(entity.getUserName())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}

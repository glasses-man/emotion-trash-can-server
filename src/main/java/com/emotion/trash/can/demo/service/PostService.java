package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.EmotionDTO;
import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.dto.PostListDTO;
import com.emotion.trash.can.demo.dto.request.PageRequest;
import com.emotion.trash.can.demo.dto.request.PostSearchRequest;
import com.emotion.trash.can.demo.entity.PostEntity;

import java.util.List;

public interface PostService {
    Long register(PostDTO dto);

    void modify(PostDTO dto);

    void emotionModify(EmotionDTO dto);

    default PostEntity dtoToEntity(PostDTO dto) {
        PostEntity entity = PostEntity.builder()
                .postId(dto.getPostId())
                .title(dto.getTitle())
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
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

    List<PostListDTO> postList(PageRequest pageRequest);

    List<PostListDTO> postSearch(PostSearchRequest request);
}

package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.entity.PostEntity;
import com.emotion.trash.can.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    @Override
    public Long register(PostDTO dto) {
        PostEntity entity = dtoToEntity(dto);
        postRepository.save(entity);
        return entity.getPostId();
    }

    @Override
    public PostDTO get(Long postId) {
        Optional<PostEntity> result = postRepository.findById(postId);
        return (result.isPresent()) ? entityToDto(result.get()) : null;
    }

    @Override
    public void modify(PostDTO dto) {
        Optional<PostEntity> result = postRepository.findById(dto.getPostId());
        if (result.isPresent()) {
            PostEntity postEntity = result.get();
            postEntity.updateTitle(dto.getTitle());
            postEntity.updateContent(dto.getContent());
            postRepository.save(postEntity);
        }
    }

    @Override
    public void remove(Long postId) {
        postRepository.deleteById(postId);
    }
}

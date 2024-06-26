package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.EmotionDTO;
import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.dto.PostListDTO;
import com.emotion.trash.can.demo.dto.request.PageRequest;
import com.emotion.trash.can.demo.dto.request.PostSearchRequest;
import com.emotion.trash.can.demo.entity.EmotionEntity;
import com.emotion.trash.can.demo.entity.PostEntity;
import com.emotion.trash.can.demo.repository.EmotionRepository;
import com.emotion.trash.can.demo.repository.PostRepository;
import com.emotion.trash.can.demo.repository.query.PostQueryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{
    private final EmotionRepository emotionRepository;
    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;
    @Override
    @Transactional(rollbackOn = Exception.class)
    public Long register(PostDTO dto) {
        PostEntity entity = dtoToEntity(dto);
        PostEntity post = postRepository.save(entity);
        for(String e : dto.getEmotion()){
            EmotionEntity emotion = EmotionEntity.builder()
                    .content(e)
                    .post(post)
                    .build();
            emotionRepository.save(emotion);
        }
        return entity.getPostId();
    }

    @Override
    public void delete(Long postId) {
        Optional<PostEntity> post = postRepository.findById(postId);
        List<EmotionEntity> emotionResult = emotionRepository.findByPost(post.get());
        emotionRepository.deleteAll(emotionResult);
        postRepository.delete(post.get());
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
    public void emotionModify(EmotionDTO dto) {
        EmotionEntity result = emotionRepository.findById(dto.getId()).get();
        result.modify(dto.getContent());
        emotionRepository.save(result);
    }

    @Override
    public List<PostListDTO> postList(PageRequest pageRequest) {
        return postQueryRepository.postList(pageRequest);
    }

    @Override
    public List<PostListDTO> postSearch(PostSearchRequest request) {
        return postQueryRepository.postSearch(request);
    }

}

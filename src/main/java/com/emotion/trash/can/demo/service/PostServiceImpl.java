package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.EmotionDTO;
import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.entity.EmotionEntity;
import com.emotion.trash.can.demo.entity.PostEntity;
import com.emotion.trash.can.demo.repository.EmotionRepository;
import com.emotion.trash.can.demo.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{
    private final EmotionRepository emotionRepository;
    private final PostRepository postRepository;
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

}

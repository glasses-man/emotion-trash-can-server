package com.emotion.trash.can.demo.repository;

import com.emotion.trash.can.demo.entity.EmotionEntity;
import com.emotion.trash.can.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmotionRepository extends JpaRepository<EmotionEntity, Long> {
    List<EmotionEntity> findByPost(PostEntity post);
}

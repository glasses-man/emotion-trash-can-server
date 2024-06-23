package com.emotion.trash.can.demo.repository;

import com.emotion.trash.can.demo.entity.EmotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<EmotionEntity, Long> {
}

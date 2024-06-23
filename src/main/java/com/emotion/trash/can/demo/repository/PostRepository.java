package com.emotion.trash.can.demo.repository;

import com.emotion.trash.can.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}

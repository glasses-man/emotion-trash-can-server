package com.emotion.trash.can.demo.repository;

import com.emotion.trash.can.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    UserEntity findById(@Param("id") String id);
}

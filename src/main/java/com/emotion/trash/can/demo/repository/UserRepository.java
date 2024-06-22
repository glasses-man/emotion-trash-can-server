package com.emotion.trash.can.demo.repository;

import com.emotion.trash.can.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.UserDTO;
import com.emotion.trash.can.demo.entity.UserEntity;

public interface BoardService {
    Long register(UserDTO dto);
    UserDTO get(Long userID);

    void modify(UserDTO dto);
    void remove(Long userID);
    default UserDTO dtoToEntity(UserDTO dto) {
        UserEntity entity = UserEntity.builder()
    }
}

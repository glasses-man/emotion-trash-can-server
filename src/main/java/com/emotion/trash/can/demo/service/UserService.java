package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.UserDTO;
import com.emotion.trash.can.demo.entity.UserEntity;

public interface UserService {
    Long signUp(UserDTO dto);
    UserDTO get(Long userID);
    void modify(UserDTO dto);
    void remove(Long userID);
    boolean signIn(String id, String password);

    default UserEntity dtoToEntity(UserDTO dto) {
        UserEntity entity = UserEntity.builder()
                .userID(dto.getUserID())
                .id(dto.getId())
                .password(dto.getPassword())
                .userName(dto.getUserName())
                .build();
        return entity;
    }

    default UserDTO entityToDto(UserEntity entity) {
        UserDTO dto = UserDTO.builder()
                .userID(entity.getUserID())
                .id(entity.getId())
                .password(entity.getPassword())
                .userName(entity.getUserName())
                .build();
        return dto;
    }


}

package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.UserDTO;
import com.emotion.trash.can.demo.entity.UserEntity;
import com.emotion.trash.can.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Long register(UserDTO dto) {
        log.info("register:");
        log.info(dto.toString());
        UserEntity userEntity = dtoToEntity(dto);
        userRepository.save(userEntity);
        return userEntity.getUserID();
    }

    @Override
    public UserDTO get(Long userID) {
        Optional<UserEntity> result = userRepository.findById(userID);
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void modify(UserDTO dto) {
        Optional<UserEntity> result = userRepository.findById(dto.getUserID());
        if (!result.isPresent()) return;
        UserEntity userEntity = result.get();
        userEntity.updateUserName(dto.getUserName());
        userEntity.updatePassword(dto.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public void remove(Long userID) {
        userRepository.deleteById(userID);
    }
}

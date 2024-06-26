package com.emotion.trash.can.demo.service;

import com.emotion.trash.can.demo.dto.UserDTO;
import com.emotion.trash.can.demo.entity.UserEntity;
import com.emotion.trash.can.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public Long signUp(UserDTO dto) {
        log.info("register:");
        log.info(dto.toString());
        UserEntity userEntity = dtoToEntity(dto);
        userRepository.save(userEntity);
        return userEntity.getUserID();
    }

    @Override
    public String signIn(String id, String password) {
        UserEntity userEntity = userRepository.findById(id);
        if (userEntity == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        if (userEntity.getPassword().equals(password)) {
            throw new RuntimeException("User not found with password: " + password);
        }
        return userEntity.getUserName();
    }
}

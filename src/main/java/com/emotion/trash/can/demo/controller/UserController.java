package com.emotion.trash.can.demo.controller;

import com.emotion.trash.can.demo.dto.UserDTO;
import com.emotion.trash.can.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{userID}")
    public UserDTO get(@PathVariable("userID") Long userID) {
        return userService.get(userID);
    }

    @PostMapping()
    public Long register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PutMapping()
    public void modify(@RequestBody UserDTO userDTO) {
        userService.modify(userDTO);
    }

    @DeleteMapping("/{userID}")
    public void delete(@PathVariable("userID") Long userID) {
        userService.remove(userID);
    }

}

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

    @GetMapping("/{id}/{password}")
    public String signIn(@PathVariable String id, String password) {
        return userService.signIn(id, password);
    }

    @PostMapping()
    public Long signUp(@RequestBody UserDTO userDTO) {
        return userService.signUp(userDTO);
    }

}

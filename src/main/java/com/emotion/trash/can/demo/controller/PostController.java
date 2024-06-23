package com.emotion.trash.can.demo.controller;


import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;


    @PostMapping("")
    public Long register(@RequestBody PostDTO dto) {
        return postService.register(dto);
    }

    @PutMapping("")
    public void modify(@RequestBody PostDTO dto) {
        postService.modify(dto);
    }

}

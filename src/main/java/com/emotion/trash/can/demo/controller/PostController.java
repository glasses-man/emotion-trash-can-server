package com.emotion.trash.can.demo.controller;


import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.dto.PostListDTO;
import com.emotion.trash.can.demo.dto.request.PageRequest;
import com.emotion.trash.can.demo.dto.request.PostSearchRequest;
import com.emotion.trash.can.demo.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("")
    public void delete(@RequestBody PostDTO dto){
        postService.delete(dto.getPostId());
    }

    @PutMapping("")
    public void modify(@RequestBody PostDTO dto) {
        postService.modify(dto);
    }

    @GetMapping("")
    public List<PostListDTO> postList(PageRequest pageRequest) {
        return postService.postList(pageRequest);
    }

    @GetMapping("/list")
    public List<PostListDTO> postSearch(PostSearchRequest request) {
        return postService.postSearch(request);
    }

}

package com.emotion.trash.can.demo.controller;

import com.emotion.trash.can.demo.dto.EmotionDTO;
import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emotion")
@RequiredArgsConstructor
@Slf4j
public class EmotionController {
    private final PostService postService;

    @PutMapping("")
    public void modify(@RequestBody EmotionDTO dto) {
        postService.emotionModify(dto);
    }
}

package com.sparta.blogretry.controller;

import com.sparta.blogretry.Service.PostService;
import com.sparta.blogretry.dto.CreatePostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 작성. dto를 통해 받은 데이터들를
    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostRequestDto createPostRequestDto) { // Json이라는 형태로 body형식으로 들어올거다.
        postService.createPost(createPostRequestDto);
    }
}

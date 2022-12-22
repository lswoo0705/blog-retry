package com.sparta.blogretry.controller;

import com.sparta.blogretry.Service.PostService;
import com.sparta.blogretry.dto.CreatePostRequestDto;
import com.sparta.blogretry.dto.GetPostResponseDto;
import com.sparta.blogretry.dto.UpdatePostRequestDto;
import com.sparta.blogretry.entity.Post;
import org.springframework.web.bind.annotation.*;


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

//    @GetMapping("/posts")
//    public void getPost() {
//        postService.getPost();
//    }

    // 선택 게시글 조회
    @GetMapping("/posts/{postId}")
    public GetPostResponseDto getSelectedPost(@PathVariable Long postId) {
        return postService.getSelectedPost(postId);
    }

    // 게시글 수정하기
    @PutMapping("/posts/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequestDto updatePostRequestDto) {
        postService.updatePost(postId, updatePostRequestDto);
    }

    @DeleteMapping("/posts/{postId}") // @DeleteMapping은 @RequestBody를 사용할 수 없다 -> @RequestParam
    public void deletePost(@PathVariable Long postId, @RequestParam String password) {
        postService.deletePost(postId, password);
    }
}

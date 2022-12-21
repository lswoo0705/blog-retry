package com.sparta.blogretry.Service;

import com.sparta.blogretry.dto.CreatePostRequestDto;
import com.sparta.blogretry.entity.Post;
import com.sparta.blogretry.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service // DB 또는 Controller를 통해 전달받은 데이터를 가지고 DB나 entity + entity에 있는 행위(update)들 일을 시킴
public class PostService {

    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 작성. dto에서 파라미터를 받고 객체 생성해서 레퍼지토리에 저장해라
    public void createPost(CreatePostRequestDto createPostRequestDto) {
        Post post = new Post(createPostRequestDto.getPosttitle(), createPostRequestDto.getUsername(), createPostRequestDto.getContent(), createPostRequestDto.getPassword());
        postRepository.save(post);
    }
}
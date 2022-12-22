package com.sparta.blogretry.Service;

import com.sparta.blogretry.dto.CreatePostRequestDto;
import com.sparta.blogretry.dto.GetPostResponseDto;
import com.sparta.blogretry.dto.UpdatePostRequestDto;
import com.sparta.blogretry.entity.Post;
import com.sparta.blogretry.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    // 게시글 조회.
//    public List<Post> getPost() {
//        return postRepository.findAll();
//    }

    // 선택 게시글 조회
    public GetPostResponseDto getSelectedPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("조회하신 아이디의 게시글이 없습니다.")
        );
        return new GetPostResponseDto(post);
    }

    // 게시글 수정
    public void updatePost(Long postId, UpdatePostRequestDto updatePostRequestDto) {
        Post savedPost = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("조회하신 아이디의 게시글이 없습니다.")
        );
        // 입력받은 비밀번호가 일치한다면 수저한 내용을 savedPost 객체에 저장하고 레퍼지토리에 저장
        if (savedPost.isValidPassword(updatePostRequestDto.getPassword())) {
            savedPost.updatePost(updatePostRequestDto.getPosttitle(), updatePostRequestDto.getUsername(), updatePostRequestDto.getContent());
            postRepository.save(savedPost);
            // if (updatePostRequestDto.getPassword().equals(savedPost.getPassword())) 이렇게 하면 일을 시키는 애가 일을 하는꼬라지
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }
}
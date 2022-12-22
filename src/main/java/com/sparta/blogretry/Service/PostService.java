package com.sparta.blogretry.Service;

import com.sparta.blogretry.dto.CreatePostRequestDto;
import com.sparta.blogretry.dto.DeletePostRequestDto;
import com.sparta.blogretry.dto.GetPostResponseDto;
import com.sparta.blogretry.dto.UpdatePostRequestDto;
import com.sparta.blogretry.entity.Post;
import com.sparta.blogretry.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional // Post를 노려보고있다가 덩어리가 끝날 때 변화가 있으면 업데이트 쿼리를 알아서 날려줌
    public void updatePost(Long postId, UpdatePostRequestDto updatePostRequestDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("조회하신 아이디의 게시글이 없습니다.")
        );
        // 입력받은 비밀번호가 일치한다면 수저한 내용을 savedPost 객체에 저장하고 레퍼지토리에 저장
        if (post.isValidPassword(updatePostRequestDto.getPassword())) {
            post.updatePost(updatePostRequestDto.getPosttitle(), updatePostRequestDto.getUsername(), updatePostRequestDto.getContent());
            postRepository.save(post); // 얘가 없더라도 @Transactional을 붙여주면 저장 됨. 다른 사람의 입장에서 명시적으로 보여주기 위해 작성해두는게 좋다.
            // if (updatePostRequestDto.getPassword().equals(savedPost.getPassword())) 이렇게 하면 일을 시키는 애가 일을 하는꼬라지
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }

    public void deletePost(Long postId, String password) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("조회하신 아이디의 게시글이 없습니다.")
        );
        if (post.isValidPassword(password)) { // 패스워드가 일치한다면.
            postRepository.delete(post);
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }
}
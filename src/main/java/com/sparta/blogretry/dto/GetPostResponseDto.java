package com.sparta.blogretry.dto;

import com.sparta.blogretry.entity.Post;
import lombok.Getter;

@Getter
public class GetPostResponseDto {
    private final String posttitle;
    private final String username;
    private final String content;

    public GetPostResponseDto(Post post) {
        this.posttitle = post.getPosttitle();
        this.username = post.getUsername();
        this.content = post.getContent();
    }
}

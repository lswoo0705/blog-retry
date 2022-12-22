package com.sparta.blogretry.dto;

import com.sparta.blogretry.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPostResponseDto {
    private final String posttitle;
    private final String username;
    private final String content;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateUpdated;
    public GetPostResponseDto(Post post) {
        this.posttitle = post.getPosttitle();
        this.username = post.getUsername();
        this.content = post.getContent();
        this.dateCreated = post.getDateCreated();
        this.dateUpdated = post.getDateUpdated();
    }
}

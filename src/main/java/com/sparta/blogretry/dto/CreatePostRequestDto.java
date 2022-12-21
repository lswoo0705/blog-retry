package com.sparta.blogretry.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // json형태로 들어온 값을 형식에 맞게 넣어달라(기본생성자 역할)
public class CreatePostRequestDto {
    private String posttitle;
    private String username;
    private String content;
    private String password;

}
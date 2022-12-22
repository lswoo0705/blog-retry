package com.sparta.blogretry.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePostRequestDto {
    private String posttitle;
    private String username;
    private String content;
    private String password;
}

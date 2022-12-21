package com.sparta.blogretry.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String posttitle;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    // 생성자
    public Post(String posttitle, String username, String content, String password) {
        this.posttitle = posttitle;
        this.username = username;
        this.content = content;
        this.password = password;
    }

    // 업데이트 기능
    public void updatePost(String posttitle, String username, String content, String password) {
        this.posttitle = posttitle;
        this.username = username;
        this.content = content;
    }
}

package com.sparta.blogretry.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Post extends TimeStamped{ // TimeStamped를 상속받으면 내가 컨트롤 하지 않아도 적용 된다.
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
    public void updatePost(String posttitle, String username, String content) {
        this.posttitle = posttitle;
        this.username = username;
        this.content = content;
    }

    // 비밀번호 일치여부 확인
    public boolean isValidPassword(String inputPassword) {
        if (inputPassword.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}

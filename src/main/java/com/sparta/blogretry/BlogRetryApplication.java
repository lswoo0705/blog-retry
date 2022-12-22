package com.sparta.blogretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogRetryApplication.class, args);
    }

}

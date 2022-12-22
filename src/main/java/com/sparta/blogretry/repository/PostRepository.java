package com.sparta.blogretry.repository;

import com.sparta.blogretry.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByDateCreatedDesc();
}
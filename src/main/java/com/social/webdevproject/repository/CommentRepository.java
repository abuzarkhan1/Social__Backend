package com.social.webdevproject.repository;

import com.social.webdevproject.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    
}

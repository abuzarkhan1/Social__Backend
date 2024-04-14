package com.social.webdevproject.service;

import com.social.webdevproject.models.Comment;
import com.social.webdevproject.models.Post;
import com.social.webdevproject.models.User;
import com.social.webdevproject.repository.CommentRepository;
import com.social.webdevproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CommentServiceImplementation implements CommentService{

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public Comment createComments(Comment comment, Integer postId, Integer userId) throws Exception {

        User user = userService.findUserById(userId);

        Post post = postService.findPostById(userId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);

        post.getComments().add(savedComment);

        postRepository.save(post);
        return savedComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        Optional<Comment> opt = commentRepository.findById(commentId);


        return null;
    }

    @Override
    public Comment likeComment(Integer CommentId, Integer userId) {
        return null;
    }
}
//8:01:06
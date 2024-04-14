package com.social.webdevproject.service;

import com.social.webdevproject.models.Comment;

public interface CommentService {

    public Comment createComments(Comment comment, Integer postId, Integer userId) throws Exception;

    public Comment findCommentById(Integer commentId);

    public Comment likeComment(Integer CommentId,Integer userId);


}

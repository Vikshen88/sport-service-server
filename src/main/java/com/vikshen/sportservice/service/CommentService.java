package com.vikshen.sportservice.service;

import com.vikshen.sportservice.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(int id);

    Comment addComment(Comment comment);

    void changeComment(Comment comment);

    List<Comment> findByPost(int id);

}

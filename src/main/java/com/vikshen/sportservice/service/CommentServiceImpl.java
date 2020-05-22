package com.vikshen.sportservice.service;

import com.vikshen.sportservice.entity.Comment;
import com.vikshen.sportservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public Comment addComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void changeComment(Comment comment) {

    }

    @Override
    public List<Comment> findByPost(int id) {
        return commentRepository.findByPost(id);
    }
}

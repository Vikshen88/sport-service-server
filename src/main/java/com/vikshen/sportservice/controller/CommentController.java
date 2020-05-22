package com.vikshen.sportservice.controller;

import com.vikshen.sportservice.entity.Comment;
import com.vikshen.sportservice.exception.NotFoundException;
import com.vikshen.sportservice.service.CommentService;
import com.vikshen.sportservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public List<Comment> getAllComments(){
        return commentService.findAll();
    }

    //REMAKE IT (MAYBE)
    @GetMapping("/{id}")
    public List<Comment> getCommentsByPost(@PathVariable int id){
        if(id<0 || id>postService.numberOfPosts() || commentService.findByPost(id).isEmpty()){
            throw new NotFoundException("Comments for post with id: " + id + " don`t exist");
        }

        return commentService.findByPost(id);
    }

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment){
        comment.setId(0);
        return commentService.addComment(comment);
    }

}

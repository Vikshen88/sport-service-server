package com.vikshen.sportservice.controller;

import com.vikshen.sportservice.entity.Post;
import com.vikshen.sportservice.exception.NotFoundException;
import com.vikshen.sportservice.repository.PostRepository;
import com.vikshen.sportservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{category}")
    public Page<Post> getPostByCategory(@PathVariable String category, @RequestParam("page") int page){
         if(page<0 || page>=postService.findByCategory(category, page).getTotalPages()){
             throw new NotFoundException("Page number: " + page + " doest`n exist");
         }
         return postService.findByCategory(category,page);
    }

    @GetMapping("article/{id}")
    public Post getPost(@PathVariable int id){
        if(id>postService.numberOfPosts() || id<0){
            throw new NotFoundException("Post with id: " + id + " not found");
        }
       Post post = postService.findById(id);
       return  post;
    }

    @GetMapping("/")
    public Page<Post> getAllPosts(@RequestParam("page") int page){
        if(page<0 || page>postService.findAll(page).getTotalPages()){
            throw new NotFoundException("Page number: " + page + " doest`n exist");
        }
        return postService.findAll(page);
    }

    @PostMapping("/{id}")
    public void increaseHits(@PathVariable int id){
        postService.increaseHits(id);

    }

    @PostMapping(value = "/addPost")
    public void addPost(@RequestBody @Valid Post post){
        postService.addPost(post);

    }

}

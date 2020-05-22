package com.vikshen.sportservice.service;

import com.vikshen.sportservice.entity.Post;
import org.springframework.data.domain.Page;


import java.util.List;


public interface PostService {

    Post findById(int id);

    Page<Post> findAll(int page);

    void increaseHits(int id);

    void addPost(Post post);

    Page<Post> findByCategory(String category, int page);

    int numberOfPosts();


}

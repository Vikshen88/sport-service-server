package com.vikshen.sportservice.service;

import com.vikshen.sportservice.entity.Post;
import com.vikshen.sportservice.repository.MatchRepository;
import com.vikshen.sportservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MatchRepository matchRepository;

    @Override
    @Transactional
    public Post findById(int id) {
        Optional<Post> result = postRepository.findById(id);

        Post post = new Post();

        if(result.isPresent()) {
            post = result.get();
        }

        return post;
    }


    @Override
    @Transactional
    public Page<Post> findAll(int page ) {

        PageRequest pageable =  PageRequest.of(page,2);
        return postRepository.findAll(pageable);
    }

    //REMAKE
    @Override
    @Transactional
    public void increaseHits(int id) {
        Optional<Post> result = postRepository.findById(id);

        Post post = new Post();

        if(result.isPresent()) {
            post = result.get();
        }



        postRepository.save(post);
    }

    //COMPLETE IT
    @Override
    @Transactional
    public void addPost(Post post) {
        post.setId(0);

        post.getMatch().setId(0);

        matchRepository.save(post.getMatch());

        postRepository.save(post);

    }

    @Override
    @Transactional
    public Page<Post> findByCategory(String category, int page) {
        PageRequest pageable =  PageRequest.of(page,2);
        return postRepository.findByCategory(category, pageable);
    }

    @Override
    public int numberOfPosts() {
        return postRepository.countPosts();
    }


}

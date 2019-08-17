package com.ajna.service;


import com.ajna.model.Post;
import com.ajna.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> findAll(int page, int size) {
        // TODO change sorting to sort by creation date (now sorting by date doesn't work for some reason)
        return postRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
    }

    @Override
    public Page<Post> findAllOrderByDateAsc(int page, int size) {
        return postRepository.findAll(PageRequest.of(page, size));
    }


    @Override
    public Post findById(long id) {
        Post post = null;
        Optional<Post> optPost = postRepository.findById(id);
        if(optPost.isPresent()){
            post = optPost.get();
        }
        return post;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }

}

package com.ajna.service;

import com.ajna.model.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Page<Post> findAll(int page, int size);
    Page<Post> findAllOrderByDateAsc(int page, int size);
    Post findById(long id);
    void save(Post Post);
    void deleteById(long id);
}

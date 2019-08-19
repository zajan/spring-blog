package com.ajna.service;

import com.ajna.model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> findAll();
    public Comment findById(long id);
    public void save(Comment comment);
    public void deleteById(long id);

}

package com.ajna.service;

import com.ajna.model.Comment;
import com.ajna.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(long id) {
        Comment comment = null;
        Optional<Comment> optComment = commentRepository.findById(id);
        if(optComment.isPresent()){
            comment = optComment.get();
        }
        return comment;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }
}

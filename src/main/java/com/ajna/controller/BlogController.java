package com.ajna.controller;

import com.ajna.model.Post;
import com.ajna.service.CustomUserDetailsService;
import com.ajna.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class BlogController {

    @Autowired
    PostService postService;

    @Autowired
    CustomUserDetailsService userService;

    @GetMapping("/posts")
    public String posts(Model model, Principal principal, HttpServletRequest request) {
        int page = 0;
        int size = 5;

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("posts", postService.findAll(page, size));
        return "posts";
    }

    @GetMapping("/new-post")
    public String newPost(Model model) {
        Post post = new Post();
        model.addAttribute(post);
        return "new-post-form";
    }

    @PostMapping("/save-post")
    public String savePost(@ModelAttribute("post") Post post, Principal principal) {
        if (principal != null) {
            post.setUser(userService.findByUsername(principal.getName()));
        }
        postService.save(post);
        return "redirect:/posts";
    }

}
package com.ajna.controller;

import com.ajna.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class BlogController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public String posts(Model model, Principal principal, HttpServletRequest request) {
        model.addAttribute("posts", postService.findAll());
        return "posts";
    }
}

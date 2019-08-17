package com.ajna;

import com.ajna.model.Post;
import com.ajna.model.Role;
import com.ajna.model.User;
import com.ajna.service.CustomUserDetailsService;
import com.ajna.service.PostService;
import com.ajna.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @PostConstruct
    public void init(){

        // adding sample data

        String roleAdminName = "ROLE_ADMIN";
        Role roleAdmin = roleService.findByName(roleAdminName);
        if(roleAdmin == null){
            roleAdmin = new Role();
            roleAdmin.setName(roleAdminName);
            roleService.save(roleAdmin);

            roleAdmin = roleService.findByName(roleAdminName);
        }

        String roleUserName = "ROLE_USER";
        Role roleUser = roleService.findByName(roleUserName);
        if(roleUser == null){
            roleUser = new Role();
            roleUser.setName(roleUserName);
            roleService.save(roleUser);

            roleUser = roleService.findByName(roleUserName);
        }


        User user = new User("user", "{noop}user", Arrays.asList(roleUser));
        if(userService.findByUsername(user.getUsername()) == null){
            userService.save(user);
        }
        User admin = new User("admin", "{noop}admin", Arrays.asList(roleAdmin, roleUser));
        if(userService.findByUsername(admin.getUsername()) == null){
            userService.save(admin);
        }


        if(postService.findAll().size() == 0){
            Post post;
            for(int i =0; i<6; i++){
                post = new Post();
                post.setTitle("My sample post nr " + i);
                post.setBody("This is the body of my sample post nr " + i);
                post.setUser(admin);

                postService.save(post);
            }
        }

    }
}

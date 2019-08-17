package com.ajna.service;

import com.ajna.model.Role;
import com.ajna.model.User;
import com.ajna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger log = Logger.getLogger( CustomUserDetailsService.class.getName() );

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername() starting...");
        User user = null;
        Optional<User> optUser = userRepository.findByUsername(username);
        user = optUser.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public User findById(long id) {
        User user = null;
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isPresent()){
            user = optUser.get();
        }
        return user;
    }
    public User findByUsername(String username){
        User user = null;
        Optional<User> optUser = userRepository.findByUsername(username);
        if(optUser.isPresent()){
            user = optUser.get();
        }
        return user;    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}

package com.ajna.service;

import com.ajna.model.Role;
import com.ajna.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(long id) {
        Role role = null;
        Optional<Role> optRole = roleRepository.findById(id);
        if(optRole.isPresent()){
            role = optRole.get();
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}

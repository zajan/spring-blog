package com.ajna.service;


import com.ajna.model.Role;

public interface RoleService {

    Role findById(long id);
    Role findByName(String name);
    void save(Role role);
}

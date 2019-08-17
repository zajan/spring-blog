package com.ajna.repository;

import com.ajna.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>{
    // should return only 1 or 0 roles because field name is marked as unique
    Role findByName(String name);
}

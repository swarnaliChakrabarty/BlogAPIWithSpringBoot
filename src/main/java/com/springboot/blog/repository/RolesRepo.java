package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entities.Role;

public interface RolesRepo extends JpaRepository<Role,Integer>{

}

package com.springboot.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
//	to load username by email in database authentication
	Optional <User> findByEmail(String email);
}

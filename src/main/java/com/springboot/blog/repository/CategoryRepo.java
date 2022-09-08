package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entities.Category;


public interface CategoryRepo extends JpaRepository<Category,Integer> {

}

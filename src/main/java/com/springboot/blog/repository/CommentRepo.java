package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entities.Comment;



public interface CommentRepo extends JpaRepository<Comment,Integer> {

}

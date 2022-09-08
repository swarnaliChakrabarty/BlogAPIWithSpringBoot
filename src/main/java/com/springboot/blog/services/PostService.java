package com.springboot.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Post;
import com.springboot.blog.payloads.PostDto;

@Service
public interface PostService {
	PostDto createPost(PostDto post,Integer uId,Integer cId);
	PostDto updatePost(PostDto user,Integer postId);
	PostDto getPostById(Integer postId);
	List<PostDto>getAllPosts();
	void deletePost(Integer postId);
	List<PostDto> getPostsByCategory(Integer cId);
	List<PostDto> getPostsByUser(Integer uId);
//	List<PostDto> searchPosts(String keyword);
	
}

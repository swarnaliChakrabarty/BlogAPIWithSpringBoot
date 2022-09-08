package com.springboot.blog.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Category;
import com.springboot.blog.entities.Post;
import com.springboot.blog.entities.User;
import com.springboot.blog.exceptions.ResourseNotFoundException;
import com.springboot.blog.payloads.CategoryDto;
import com.springboot.blog.payloads.PostDto;
import com.springboot.blog.repository.CategoryRepo;
import com.springboot.blog.repository.PostRepo;
import com.springboot.blog.repository.UserRepo;
import com.springboot.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer uId, Integer cId) {
		User user=this.userRepo.findById(uId).orElseThrow(()->new ResourseNotFoundException("user","Id",uId));
		Category category =this.categoryRepo.findById(cId).orElseThrow(()->new ResourseNotFoundException("category","Id",cId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setDate(new Date());
		
		post.setCategory(category);
		post.setUser(user);
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost,PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
	
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundException("Post", " Id ", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		Post updatedPost = this.postRepo.save(post);

		return this.modelMapper.map(updatedPost,PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundException("Post", " Id ", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPosts() {
	

		List<Post> posts = this.postRepo.findAll();
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public void deletePost(Integer postId) {
	Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourseNotFoundException("Post","Id",postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer cId) {
		Category cat=this.categoryRepo.findById(cId).orElseThrow(()->new ResourseNotFoundException("category","Id",cId));
		System.out.println(cat.getCategoryTitle());
		List<Post>posts=this.postRepo.findByCategory(cat);
		System.out.println(posts);
		List<PostDto> postDtos=posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer uId) {
	
		User user=this.userRepo.findById(uId)
				.orElseThrow(()->new ResourseNotFoundException("user","Id",uId));
		List<Post>posts=this.postRepo.findByUser(user);
		List<PostDto> postDtos=posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}
//
//	@Override
//	public List<PostDto> searchPosts(String keyword) {
//		
//		return null;
//	}



	

}

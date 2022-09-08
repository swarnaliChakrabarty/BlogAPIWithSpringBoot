package com.springboot.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payloads.ApiResponse;
import com.springboot.blog.payloads.CategoryDto;
import com.springboot.blog.payloads.PostDto;
import com.springboot.blog.services.PostService;


@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//Add users
	@PostMapping("/user/{id}/category/{cId}/posts")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,@PathVariable Integer id,@PathVariable Integer cId){
		PostDto createPostDto=this.postService.createPost(postDto, id, cId);
		return new ResponseEntity<>(createPostDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/{id}/posts")
	public ResponseEntity<List<PostDto>> getAllPostsByUser(@PathVariable Integer id){
		List<PostDto>posts=this.postService.getPostsByUser(id);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{cId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable Integer cId){
		List<PostDto>posts=this.postService.getPostsByCategory(cId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto>posts=this.postService.getAllPosts();
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	@GetMapping("/posts/{postId}")
	public ResponseEntity<List<PostDto>> getAllPosts(@PathVariable Integer postId){
		PostDto post=this.postService.getPostById(postId);
		return new ResponseEntity(post,HttpStatus.OK);
	}
	
	@PutMapping("posts/{postId}")
	public ResponseEntity<PostDto> createUser(@Valid @RequestBody PostDto postDto,@PathVariable Integer postId){
		 PostDto updatePost=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer postId){
		postService.deletePost(postId);
		return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
		
	}

}

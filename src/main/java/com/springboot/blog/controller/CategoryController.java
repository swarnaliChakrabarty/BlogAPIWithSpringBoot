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
import com.springboot.blog.services.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//Add users
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createUser(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategoryDto=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategoryDto,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{cId}")
	public ResponseEntity<CategoryDto> createUser(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer cId){
		CategoryDto updateCategoryDto=this.categoryService.updateCategory(categoryDto,cId);
		return new ResponseEntity<>(updateCategoryDto,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{cId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer cId){
		categoryService.deleteCategory(cId);
		return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllUser(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
	
	@GetMapping("/{cId}")
	public ResponseEntity<CategoryDto> getUserById(@PathVariable Integer cId){
		return ResponseEntity.ok(this.categoryService.getCategoryById(cId));
	}
}

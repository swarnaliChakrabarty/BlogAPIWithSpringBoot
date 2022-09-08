package com.springboot.blog.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.blog.payloads.CategoryDto;


@Component
public interface CategoryService {
	CategoryDto createCategory(CategoryDto category);

	CategoryDto updateCategory(CategoryDto category, Integer cId);

	CategoryDto getCategoryById(Integer cId);

	List<CategoryDto> getAllCategory();

	void deleteCategory(Integer cId);
}

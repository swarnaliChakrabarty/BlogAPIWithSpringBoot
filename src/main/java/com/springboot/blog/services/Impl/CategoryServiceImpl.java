package com.springboot.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Category;
import com.springboot.blog.entities.User;
import com.springboot.blog.exceptions.ResourseNotFoundException;
import com.springboot.blog.payloads.CategoryDto;
import com.springboot.blog.payloads.UserDto;
import com.springboot.blog.repository.CategoryRepo;
import com.springboot.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category res = this.categoryRepo.save(category);
		return this.modelMapper.map(res, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer cId) {

		Category cat = this.categoryRepo.findById(cId)
				.orElseThrow(() -> new ResourseNotFoundException("Category", " Id ", cId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDesc(categoryDto.getCategoryDesc());
		Category updatedCategory = this.categoryRepo.save(cat);

		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer cId) {

		Category cat = this.categoryRepo.findById(cId)
				.orElseThrow(() -> new ResourseNotFoundException("Category", " Id ", cId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> catogaries = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = catogaries.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());

		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer cId) {
		Category cat = this.categoryRepo.findById(cId)
				.orElseThrow(() -> new ResourseNotFoundException("Category", " Id ", cId));
		this.categoryRepo.delete(cat);
	}

}

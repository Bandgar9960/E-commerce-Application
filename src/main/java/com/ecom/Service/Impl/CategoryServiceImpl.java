package com.ecom.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.Exception.ResourceNotFoundException;
import com.ecom.Model.Category;
import com.ecom.Payloads.CategoryDto;
import com.ecom.Repository.CategoryRepo;
import com.ecom.Service.CategoryServiceI;

@Service
public class CategoryServiceImpl implements CategoryServiceI {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category saveCat = this.categoryRepo.save(category);
		CategoryDto catDto = this.modelMapper.map(saveCat, CategoryDto.class);

		return catDto;
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> allCat = this.categoryRepo.findAll();
		List<CategoryDto> CatDto = allCat.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());

		return CatDto;
	}

	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);

		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		category.setTitle(categoryDto.getTitle());

		Category saveCat = this.categoryRepo.save(category);

		CategoryDto cateDto = this.modelMapper.map(saveCat, CategoryDto.class);

		return cateDto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		this.categoryRepo.delete(category);

	}

}

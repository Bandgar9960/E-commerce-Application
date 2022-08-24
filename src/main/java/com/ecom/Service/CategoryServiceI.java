package com.ecom.Service;

import java.util.List;

import com.ecom.Payloads.CategoryDto;

public interface CategoryServiceI {

	// Create Category
	CategoryDto createCategory(CategoryDto categoryDto);

	// GetAll Category

	List<CategoryDto> getAllCategory();

	// Get Single Category

	CategoryDto getSingleCategory(Integer categoryId);

	// Update Category

	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// Delete Category

	void deleteCategory(Integer categoryId);

}

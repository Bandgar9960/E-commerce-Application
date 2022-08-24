package com.ecom.Controller;

import java.util.List;

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

import com.ecom.Payloads.ApiResponse;
import com.ecom.Payloads.CategoryDto;
import com.ecom.Service.CategoryServiceI;

@RestController
@RequestMapping("/Api")
public class CategoryController {

	@Autowired
	private CategoryServiceI categoryServiceI;

	@PostMapping("/Categories")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

		CategoryDto categoryDto2 = this.categoryServiceI.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(categoryDto2, HttpStatus.CREATED);

	}

	@GetMapping("/Categories")
	public ResponseEntity<List<CategoryDto>> getAllCat() {

		List<CategoryDto> allCat = this.categoryServiceI.getAllCategory();

		return new ResponseEntity<List<CategoryDto>>(allCat, HttpStatus.OK);

	}

	@GetMapping("/Categories/{categoryId}")
	public ResponseEntity<CategoryDto> getSingleCat(@PathVariable Integer categoryId) {

		CategoryDto singleCat = this.categoryServiceI.getSingleCategory(categoryId);

		return new ResponseEntity<CategoryDto>(singleCat, HttpStatus.OK);

	}

	@PutMapping("/Category/{categoryId}")
	public ResponseEntity<CategoryDto> updateCat(@RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {

		CategoryDto updateCat = this.categoryServiceI.updateCategory(categoryDto, categoryId);

		return new ResponseEntity<CategoryDto>(updateCat, HttpStatus.CREATED);

	}

	@DeleteMapping("/Categories/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCat(@PathVariable Integer categoryId) {

		this.categoryServiceI.deleteCategory(categoryId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Delete Sucessfully", true), HttpStatus.OK);

	}

}

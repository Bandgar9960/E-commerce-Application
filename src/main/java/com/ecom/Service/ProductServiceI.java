package com.ecom.Service;

import com.ecom.Payloads.ProductDto;
import com.ecom.Payloads.ProductResponse;

public interface ProductServiceI {

	// Insert Products
	// Product Insert karana hai in which category
	ProductDto createProduct(ProductDto productDto, Integer categoryId);

	// get All Products

	ProductResponse getAllProducts(int pageNumber, int pageSize, String sortBy, String sortDir);

	// get Product By Id

	ProductDto getSingleData(Integer productId);

	// Update Product

	ProductDto updateProduct(ProductDto productDto, Integer productId);

	// Delete Product
	void DeleteProduct(Integer productId);

	// Get All Product By Category
	ProductResponse getAllProductByCategory(Integer categoryId, int pageNumber, int pageSize, String sortBy,
			String sortDir);

}

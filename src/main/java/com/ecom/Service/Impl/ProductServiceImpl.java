package com.ecom.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecom.Exception.ResourceNotFoundException;
import com.ecom.Model.Category;
import com.ecom.Model.Product;
import com.ecom.Payloads.ProductDto;
import com.ecom.Payloads.ProductResponse;
import com.ecom.Repository.CategoryRepo;
import com.ecom.Repository.ProductRepo;
import com.ecom.Service.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto createProduct(ProductDto productDto, Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		Product product = this.modelMapper.map(productDto, Product.class);
		product.setCategory(category);
		Product saveProduct = this.productRepo.save(product);
		ProductDto productDto2 = this.modelMapper.map(saveProduct, ProductDto.class);

		return productDto2;
	}

	@Override
	public ProductResponse getAllProducts(int pageNumber, int pageSize, String sortBy, String sortDir) {

		Sort sort = null;

		if (sortDir.trim().toLowerCase().equals("asc")) {

			sort = Sort.by(sortBy).ascending();

		} else {
			sort = Sort.by(sortBy).descending();
		}

		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Product> page = this.productRepo.findAll(pageable);
		List<Product> allProduct = page.getContent();
		List<ProductDto> allProductDto = allProduct.stream()
				.map((product) -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());

		ProductResponse response = new ProductResponse();

		response.setContent(allProductDto);
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElements(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		response.setLast(page.isLast());

		return response;
	}

	@Override
	public ProductDto getSingleData(Integer productId) {

		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
		product.setProductName(productDto.getProductName());
		product.setProductDesc(productDto.getProductDesc());
		product.setProductPrice(productDto.getProductPrice());
		product.setImageName(productDto.getImageName());
		product.setProductQuantity(productDto.getProductQuantity());
		Product updateProduct = this.productRepo.save(product);
		ProductDto updatedProduct = this.modelMapper.map(updateProduct, ProductDto.class);
		return updatedProduct;
	}

	@Override
	public void DeleteProduct(Integer productId) {

		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		this.productRepo.delete(product);

	}

	@Override
	public ProductResponse getAllProductByCategory(Integer categoryId, int pageNumber, int pageSize, String sortBy,
			String sortDir) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

		Sort sort = null;

		if (sortDir.trim().toLowerCase().equals("asc")) {

			sort = Sort.by(sortBy).ascending();

		} else {
			sort = Sort.by(sortBy).descending();
		}

		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Product> page = this.productRepo.findByCategory(category, pageable);
		List<Product> categories = page.getContent();
		List<ProductDto> productDto = categories.stream()
				.map((product1) -> this.modelMapper.map(product1, ProductDto.class)).collect(Collectors.toList());

		ProductResponse response = new ProductResponse();

		response.setContent(productDto);
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElements(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		response.setLast(page.isLast());

		return response;
	}
}
package com.ecom.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Exception.ResourceNotFoundException;
import com.ecom.Payloads.ApiResponse;
import com.ecom.Payloads.ProductDto;
import com.ecom.Payloads.ProductResponse;
import com.ecom.Service.ProductServiceI;
import com.ecom.config.AppConstants;

/**
 * @version 1.0
 * @author Dnyanesh
 *
 */

@RestController
@RequestMapping("/Api")
public class ProductController {

	@Autowired
	private ProductServiceI productServiceI;

	// create product
	/**
	 * 
	 * @param productDto
	 * @param categoryId
	 * @return
	 */
	@PostMapping("/Category/{categoryId}/products")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,
			@PathVariable Integer categoryId) {

		ProductDto createProduct = this.productServiceI.createProduct(productDto, categoryId);

		return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED);

	}

	// getAll product

	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param sortBy
	 * @param sortDir
	 * @return
	 */
	@GetMapping("/products")
	public ResponseEntity<ProductResponse> getAllProducts(
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(name = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

		ProductResponse products = this.productServiceI.getAllProducts(pageNumber, pageSize, sortBy, sortDir);

		return new ResponseEntity<ProductResponse>(products, HttpStatus.OK);

	}

	// get Single Product
	/**
	 * 
	 * @param productId
	 * @return
	 * @exception ResourceNotFoundException
	 */

	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDto> getSingleProduct(@PathVariable Integer productId) {
		ProductDto singleData = this.productServiceI.getSingleData(productId);

		return new ResponseEntity<ProductDto>(singleData, HttpStatus.OK);

	}

	// update product
	/**
	 * 
	 * @param productDto
	 * @param productId
	 * @return
	 * @exception ResourceNotFoundException
	 */

	@PutMapping("/products/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,
			@PathVariable Integer productId) {

		ProductDto updatedProduct = this.productServiceI.updateProduct(productDto, productId);

		return new ResponseEntity<ProductDto>(updatedProduct, HttpStatus.CREATED);

	}

	// Delete Product
	/**
	 * 
	 * @param productId
	 * @return
	 * @exception ResourceNotFoundException
	 */
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer productId) {

		this.productServiceI.DeleteProduct(productId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Product Deleted Sucessfully", true), HttpStatus.OK);

	}

	// Get All Product By Category

	@GetMapping("/Category/{categoryId}")
	public ResponseEntity<ProductResponse> getAllProductByCat(@PathVariable Integer categoryId,
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(name = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

		ProductResponse allProducts = this.productServiceI.getAllProductByCategory(categoryId, pageNumber, pageSize,
				sortBy, sortDir);
		return new ResponseEntity<ProductResponse>(allProducts, HttpStatus.OK);

	}

}

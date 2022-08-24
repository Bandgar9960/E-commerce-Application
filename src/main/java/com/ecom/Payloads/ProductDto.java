package com.ecom.Payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

	private Integer productId;

	private String productName;

	private String productDesc;

	private Double productPrice;

	private int productQuantity;

	private boolean live;

	private String imageName;

	private boolean stock = true;

	// private Integer categoryId;

	private CategoryDto category;

}

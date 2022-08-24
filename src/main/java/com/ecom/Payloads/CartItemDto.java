package com.ecom.Payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemDto {

	private int cartItemId;

	private ProductDto product;

	private int quantity;

	private double totalProductPrice;

}

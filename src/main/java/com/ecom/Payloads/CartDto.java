package com.ecom.Payloads;

import java.util.HashSet;
import java.util.Set;

import com.ecom.Model.CartItem;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartDto {

	private int cartId;

	// Important point UserDto geun user cha reference because of mapping madhe
	// problem nahi zala pahije
	private UserDto user;

	private Set<CartItem> items = new HashSet<>();

}

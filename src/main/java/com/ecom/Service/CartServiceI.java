package com.ecom.Service;

import com.ecom.Payloads.CartDto;
import com.ecom.Payloads.ItemRequest;

public interface CartServiceI {

	// add item to cart
	// we will check the availability of card if cart is available then we will add
	// item to cart otherwise we will create a new card and add the item to it

	CartDto addItem(ItemRequest item, String username);

	// get card of user
	CartDto get(String userName);

	// remove item from cart
	CartDto removeItem(String username, int itemId);

}

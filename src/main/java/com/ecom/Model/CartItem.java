package com.ecom.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CART_ITEM")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;

	/**
	 * Unidirectional Mapping One CartItem Have Only one product
	 */
	@OneToOne
	private Product product;

	private int quantity;

	private double totalProductPrice;

	/**
	 * Many Items Have Only one Cart
	 */
	@ManyToOne
	private Cart cart;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalProductPrice() {
		return totalProductPrice;
	}

	public void setTotalProductPrice(double totalProductPrice) {
		this.totalProductPrice = this.product.getProductPrice() * this.quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}

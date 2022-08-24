package com.ecom.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;

	private int quantity;

	private Double totalOrderPrice;

	/**
	 * Many OrderItem have only one Order
	 */
	@ManyToOne
	private Order order;

	/**
	 * One OrderItem Have One Product
	 */

	@OneToOne
	private Product product;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(Double totalOrderPrice) {
		this.totalOrderPrice = this.product.getProductPrice() * this.quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

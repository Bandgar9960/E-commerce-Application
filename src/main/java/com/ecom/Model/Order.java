package com.ecom.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ORDER_ECOM")
@Setter
@Getter
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private String orderStatus;

	private String paymentStatus;

	private Date orderCreated;

	private Double orderAmount;

	private String billingAddress;

	private Date orderDelivered;

	/**
	 * One Order Have only one OrderItem
	 */

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItem = new HashSet<>();

	@OneToOne
	private User user;
}

package com.ecom.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CART")
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	@OneToOne
	private User user;

	/**
	 * One Cart Have number of items
	 */

	@OneToMany(mappedBy = "cart")
	private Set<CartItem> items = new HashSet<>();
}

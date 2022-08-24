package com.ecom.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT_DETAILS")
@Setter
@Getter
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Column(name = "PRODUCT_NAME", length = 300, unique = true)
	private String productName;

	@Column(name = "PRODUCT_DESC")
	private String productDesc;

	@Column(name = "PRODUCT_PRICE")
	private Double productPrice;

	@Column(name = "PRODUCT_QUANTITY")
	private int productQuantity;

	private boolean live;

	@Column(name = "IMAGE_NAME")
	private String imageName;

	private boolean stock = true;

	/**
	 * Many Product have Only one Category
	 */
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

}

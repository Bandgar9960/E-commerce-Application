package com.ecom.Payloads;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto {

	private int orderId;

	private String orderStatus;

	private String paymentStatus;

	private Date orderCreated;

	private Double orderAmount;

	private String billingAddress;

	private Date orderDelivered;

}

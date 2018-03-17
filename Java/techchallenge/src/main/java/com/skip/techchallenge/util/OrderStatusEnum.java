package com.skip.techchallenge.util;

/***********************************************************************************
 * Objective: Map order status
 * @author feiserte
 ***********************************************************************************/
public enum OrderStatusEnum {
	
	ORDER_CREATED("Order created."),
	ORDER_OUT_FOR_DELIVERY("Your food is out for delivery."),
	ORDER_DELIVERED("Your food was delivered."),
	ORDER_CANCELED("Order canceled."), 
	ORDER("Restaurant received order."),
	RESTAURANT_CONFIRMED_ORDER("Restaurant confirmed order.");

	private String status;

	OrderStatusEnum(String status) {
		this.status = status;
	}

	public String status() {
		return status;
	}
}

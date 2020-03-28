package com.nagp.assignmentone.orderservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orders" })
public class OrderDTO {
	
	 @JsonProperty("orders")
	 private List<OrderResponse> orders;

	public List<OrderResponse> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderResponse> orders) {
		this.orders = orders;
	}
	 
	 

	
}

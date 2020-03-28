package com.nagp.assignmentone.aggregatorservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userDetails" })
public class OrderDetailResponse {

	 @JsonProperty("userDetails")
	 private UserDTO userDetails;
	 
	 private List<OrderResponse> orders;

	public UserDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDTO userDTO) {
		this.userDetails = userDTO;
	}

	public List<OrderResponse> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderResponse> orders) {
		this.orders = orders;
	}
	 
	 
}

package com.nagp.assignmentone.aggregatorservice.service;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.nagp.assignmentone.aggregatorservice.dto.OrderDTO;
import com.nagp.assignmentone.aggregatorservice.dto.OrderDetailResponse;
import com.nagp.assignmentone.aggregatorservice.dto.UserDTO;

@Service
@ConfigurationProperties(prefix="endpoint")
public class AggregatorService {
	
	private String userurl;
	
	private String orderurl;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	/**
	 * Get the order details using userId
	 * @param userId
	 * @return
	 */
	public OrderDetailResponse getOrderDetailsByUser(int userId) {
		
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		String url = userurl + "/user/"+ userId;
		ResponseEntity<UserDTO> userResponse = restTemplate.exchange(url, HttpMethod.GET, null, UserDTO.class);
		orderDetailResponse.setUserDetails(userResponse.getBody());
		if (StringUtils.isEmpty(orderDetailResponse.getUserDetails().getError())) {
			url = orderurl + "/orders/" + userId;
			ResponseEntity<OrderDTO> orderResponse = restTemplate.exchange(url, HttpMethod.GET, null, OrderDTO.class);
			orderDetailResponse.setOrders(orderResponse.getBody().getOrders());
		}
		return orderDetailResponse;
		
	}
	
	public String getUserurl() {
		return userurl;
	}

	public void setUserurl(String userurl) {
		this.userurl = userurl;
	}

	public String getOrderurl() {
		return orderurl;
	}

	public void setOrderurl(String orderurl) {
		this.orderurl = orderurl;
	}

}

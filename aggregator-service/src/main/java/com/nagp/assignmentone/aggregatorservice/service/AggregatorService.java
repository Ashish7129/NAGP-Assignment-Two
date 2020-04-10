package com.nagp.assignmentone.aggregatorservice.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.nagp.assignmentone.aggregatorservice.dto.OrderDTO;
import com.nagp.assignmentone.aggregatorservice.dto.OrderDetailResponse;
import com.nagp.assignmentone.aggregatorservice.dto.UserDTO;

@Service
public class AggregatorService {
	
	@Autowired
	private Environment env;
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	public String getUserUrl() {
		return env.getProperty("endpoint.user.url");
	}
	
	public String getOrderUrl() {
		return env.getProperty("endpoint.order.url");
	}
	/**
	 * Get the order details using userId
	 * @param userId
	 * @return
	 */
	public OrderDetailResponse getOrderDetailsByUser(int userId) {
		
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		String url = getUserUrl() + "/user/"+ userId;
		ResponseEntity<UserDTO> userResponse = restTemplate.exchange(url, HttpMethod.GET, null, UserDTO.class);
		orderDetailResponse.setUserDetails(userResponse.getBody());
		if (StringUtils.isEmpty(orderDetailResponse.getUserDetails().getError())) {
			url = getOrderUrl() + "/orders/" + userId;
			ResponseEntity<OrderDTO> orderResponse = restTemplate.exchange(url, HttpMethod.GET, null, OrderDTO.class);
			orderDetailResponse.setOrders(orderResponse.getBody().getOrders());
		}
		return orderDetailResponse;
		
	}
}

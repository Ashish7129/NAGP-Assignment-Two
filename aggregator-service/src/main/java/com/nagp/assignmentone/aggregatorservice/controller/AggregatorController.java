package com.nagp.assignmentone.aggregatorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.aggregatorservice.dto.OrderDetailResponse;
import com.nagp.assignmentone.aggregatorservice.service.AggregatorService;

@RestController
@RequestMapping("/orderdetails")
public class AggregatorController {

	@Autowired
	private AggregatorService aggregatorService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public OrderDetailResponse getOrders(@PathVariable int userId) {
	    return aggregatorService.getOrderDetailsByUser(userId);
	  }
}

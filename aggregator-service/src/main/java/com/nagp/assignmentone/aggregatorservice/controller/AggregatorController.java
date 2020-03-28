package com.nagp.assignmentone.aggregatorservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.aggregatorservice.dto.OrderDetailResponse;
import com.nagp.assignmentone.aggregatorservice.service.AggregatorService;

/**
 * Controller which helps to aggregate the various services into one 
 * @author ashishaggarwal
 *
 */
@RestController
@RequestMapping("/orderdetails")
public class AggregatorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AggregatorController.class);

	@Autowired
	private AggregatorService aggregatorService;
	
	@GetMapping(value = "/{userId}")
	public OrderDetailResponse getOrders(@PathVariable int userId) {
		OrderDetailResponse response = null;
		try {
			LOGGER.info("Getting the aggregate result for user : {}", userId);
			response = aggregatorService.getOrderDetailsByUser(userId);
		} catch (Exception ex) {
			LOGGER.info("error : {}", ex);
		}
		return response;
	}
}

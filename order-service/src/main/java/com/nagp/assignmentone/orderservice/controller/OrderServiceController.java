package com.nagp.assignmentone.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.orderservice.dto.OrderDTO;
import com.nagp.assignmentone.orderservice.service.IOrderService;
/**
 * Controller which helps to get the order details for specific user
 * 
 * @author ashishaggarwal
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderServiceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceController.class);
	
	@Autowired
	private IOrderService orderService;
	
	@GetMapping(value = "/{userId}")
	public OrderDTO getOrders(@PathVariable int userId) {
		OrderDTO order = null;
		try {
			LOGGER.info("Getting orders for user : {}", userId);
			order = orderService.getOrders(userId);
		} catch (Exception ex) {
			LOGGER.info("error : {}", ex);
		}
		return order;
	}

}

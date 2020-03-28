package com.nagp.assignmentone.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignmentone.orderservice.dto.OrderDTO;
import com.nagp.assignmentone.orderservice.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public OrderDTO getOrders(@PathVariable int userId) {
	    return orderService.getOrders(userId);
	  }

}

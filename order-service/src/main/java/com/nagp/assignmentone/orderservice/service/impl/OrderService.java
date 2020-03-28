package com.nagp.assignmentone.orderservice.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nagp.assignmentone.orderservice.dto.OrderDTO;
import com.nagp.assignmentone.orderservice.dto.OrderResponse;
import com.nagp.assignmentone.orderservice.model.Order;
import com.nagp.assignmentone.orderservice.service.IOrderService;


@Service
public class OrderService implements IOrderService {

	static List<Order> orders = null ;
	static {
		orders = new ArrayList<>();
		orders.add(new Order(1,1,250,Calendar.getInstance().getTime()));
		orders.add(new Order(1,2,300,Calendar.getInstance().getTime()));
		orders.add(new Order(2,1,450,Calendar.getInstance().getTime()));
		orders.add(new Order(2,2,550,Calendar.getInstance().getTime()));
		orders.add(new Order(3,1,650,Calendar.getInstance().getTime()));
		
	}
	@Override
	public OrderDTO getOrders(int userId) {
		OrderDTO orderDTO = new OrderDTO();
		 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		List<OrderResponse> orderResponse = new ArrayList<>();
		List<Order> order = orders.stream().filter(p -> p.getUserId() == userId).collect(Collectors.toList());
		for (Order curOrder : order) {
			OrderResponse response = new OrderResponse();
			response.setOrderId(curOrder.getOrderId());
			response.setOrderAmount(curOrder.getOrderAmount());
			response.setOrderDate(dateFormat.format(curOrder.getOrderDate()));
			orderResponse.add(response);
			}
		
		orderDTO.setOrders(orderResponse);
		return orderDTO;
	}

}

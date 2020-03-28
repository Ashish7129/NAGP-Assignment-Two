package com.nagp.assignmentone.orderservice.service;

import com.nagp.assignmentone.orderservice.dto.OrderDTO;

public interface IOrderService {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	OrderDTO getOrders(final int userId);

}

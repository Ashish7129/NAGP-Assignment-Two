package com.nagp.assignmentone.aggregatorservice.service;

import com.nagp.assignmentone.aggregatorservice.dto.OrderDetailResponse;

public interface IAggregatorService {

	OrderDetailResponse getOrderDetailsByUser(int userId);
}

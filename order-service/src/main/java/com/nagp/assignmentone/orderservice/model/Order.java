package com.nagp.assignmentone.orderservice.model;

import java.util.Date;

public class Order {

	private int userId;
	private int orderId;
	private long orderAmount;
	private Date orderDate;
	
	public Order(int userId, int orderId, long orderAmount, Date orderDate) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public long getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
	
}

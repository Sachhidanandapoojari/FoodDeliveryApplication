package com.food.dao;

import java.util.List;

import com.food.model.Order;

public interface OrderDao {
    
	void addOrder(Order Order);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	
	List<Order> getAllOrderByUser(int userId);
}

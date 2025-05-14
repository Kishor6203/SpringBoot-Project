package com.food.service;

import java.util.List;

import com.food.Order;
import com.food.User;
import com.food.request.OrderRequest;

public interface OrderService {
	
	public Order createOrder(OrderRequest order, User user)throws Exception;
	
	public Order updateOrder(long orderId, String orderStatus) throws Exception;
	
	public void cancleOrder(long orderId) throws Exception;
	
	public List<Order> getUsersOrder(long userId) throws Exception;
	
	public List<Order> getRestaurantsOrder(long restaurantId, String orderStatus) throws Exception;
	
	public Order findOrderById(long orderId) throws Exception;

}

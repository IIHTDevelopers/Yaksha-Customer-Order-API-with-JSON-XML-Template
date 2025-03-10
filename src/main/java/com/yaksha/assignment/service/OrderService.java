package com.yaksha.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yaksha.assignment.dto.Order;

@Service
public class OrderService {

	private final List<Order> orders = new ArrayList<>();

	public OrderService() {
		// Adding sample data
		orders.add(new Order(1, "Alice Johnson", "Laptop", 1200.00));
		orders.add(new Order(2, "Bob Smith", "Smartphone", 800.00));
	}

	public Order getOrderById(int id) {
		return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
	}

	public List<Order> getAllOrders() {
		return orders;
	}

	public Order createOrder(Order order) {
		orders.add(order);
		return order;
	}

	public Order updateOrder(int id, Order order) {
		for (Order o : orders) {
			if (o.getId() == id) {
				o.setCustomerName(order.getCustomerName());
				o.setProduct(order.getProduct());
				o.setTotalAmount(order.getTotalAmount());
				return o;
			}
		}
		return null;
	}

	public void deleteOrder(int id) {
		orders.removeIf(order -> order.getId() == id);
	}
}

package com.yaksha.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.dto.Order;
import com.yaksha.assignment.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// Get order by ID
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable int id) {
		return orderService.getOrderById(id);
	}

	// Get all orders
	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	// Create a new order
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	// Update order
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}

	// Delete order by ID
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderService.deleteOrder(id);
	}
}

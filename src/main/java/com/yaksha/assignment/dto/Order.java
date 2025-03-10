package com.yaksha.assignment.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order {

	private int id;
	private String customerName;
	private String product;
	private double totalAmount;

	// Constructor
	public Order(int id, String customerName, String product, double totalAmount) {
		this.id = id;
		this.customerName = customerName;
		this.product = product;
		this.totalAmount = totalAmount;
	}

	// Getters and Setters
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@XmlElement
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@XmlElement
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}

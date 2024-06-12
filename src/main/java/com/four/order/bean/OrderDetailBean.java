package com.four.order.bean;

import java.time.LocalDateTime;

public class OrderDetailBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	//10碼 24 / 0524 / 4碼JessionID
	private String orderID;
	//101
	private int productID;
	private String productName;
	//(yyyy-MM-dd-HH-mm-ss-ns)
	private LocalDateTime orderDate;
	private int quantity;
	private int unitPrice;
	
	//default constructor
	public OrderDetailBean() {
		super();
	}
	public OrderDetailBean(String orderID, int productID, String productName, LocalDateTime orderDate, int quantity,
			int unitPrice) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.productName = productName;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
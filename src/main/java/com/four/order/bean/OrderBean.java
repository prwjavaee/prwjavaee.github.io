package com.four.order.bean;

public class OrderBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	//表單ID=> 10碼=> 24 0524 4碼JsessionID
	private String orderID;
	//八碼=> 10000001 
	private int memberID;
	private int total;
	//
	private String orderStatus;
	//default constructor
	public OrderBean() {
		super();
	}
	public OrderBean(String orderID, int memberID, int total, String orderStatus) {
		super();
		this.orderID = orderID;
		this.memberID = memberID;
		this.total = total;
		this.orderStatus = orderStatus;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
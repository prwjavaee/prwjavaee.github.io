package com.four.products.bean;

import java.util.Date;

public class Product {
	private int productID;
	private String categoryName;
	private String productName;
	private int price;
	private Date listingDate;
	private int stock;
	private String productFeatures;

	public Product() {

	}

	public Product(String categoryName, String productName, int price, Date listingDate, int stock,
			String productFeatures) {
		this.categoryName = categoryName;
		this.productName = productName;
		this.price = price;
		this.listingDate = listingDate;
		this.stock = stock;
		this.productFeatures = productFeatures;
	}

	public Product(int productID, String categoryName, String productName, int price, Date listingDate, int stock,
			String productFeatures) {
		this.productID = productID;
		this.categoryName = categoryName;
		this.productName = productName;
		this.price = price;
		this.listingDate = listingDate;
		this.stock = stock;
		this.productFeatures = productFeatures;
	}

	public int getProductID() {
		return productID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}

	public Date getListingDate() {
		return listingDate;
	}

	public int getStock() {
		return stock;
	}

	public String getProductFeatures() {
		return productFeatures;
	}

	public void setCategoryID(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setListingDate(Date listingDate) {
		this.listingDate = listingDate;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", price=" + price + ", listingDate=" + listingDate + ", stock=" + stock + ", productFeatures="
				+ productFeatures + "]";
	}

}

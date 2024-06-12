package com.four.products.bean;

public class ProductImage {
	private int imageID;
	private int productID;
	private byte[] image;

	public ProductImage() {

	}

	public ProductImage(int imageID, int productID, byte[] image) {
		this.imageID = imageID;
		this.productID = productID;
		this.image = image;
	}

	public int getImageID() {
		return imageID;
	}

	public int getProductID() {
		return productID;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}

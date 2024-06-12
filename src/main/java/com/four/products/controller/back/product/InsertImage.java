package com.four.products.controller.back.product;

import java.util.List;

import com.four.products.bean.ProductImage;
import com.four.products.dao.ProductDAO;
import com.four.products.dao.ProductImageDAO;

public class InsertImage {

	public static void searchAndInsert(List<byte[]> images) {
		int maxProductID = ProductDAO.getMaxProductID();
		ProductImageDAO imageDAO = new ProductImageDAO();
		for (byte[] image : images) {
			int maxImageID = imageDAO.getMaxImageID(maxProductID);
			ProductImage productImage = new ProductImage(maxImageID, maxProductID, image);
			imageDAO.insert(productImage);
		}
	}

	public static void searchAndInsert(byte[] image) {
		// 取得目前商品編號到幾號
		int maxProductID = ProductDAO.getMaxProductID();
		ProductImageDAO imageDAO = new ProductImageDAO();
		// 尋找目前這筆商品的商品圖片的圖片編號到幾號 如果沒有這個商品的圖片就讓圖片編號從1開始
		int maxImageID = imageDAO.getMaxImageID(maxProductID);
		ProductImage productImage = new ProductImage(maxImageID, maxProductID, image);
		imageDAO.insert(productImage);
	}
}

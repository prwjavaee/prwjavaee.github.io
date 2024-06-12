package com.four.products.controller.mall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.four.products.bean.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 建立cart
		List<List<Object>> cart = (List<List<Object>>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}
		// 從session中拿到該商品資訊與圖片
		Product product = (Product) session.getAttribute("selectedProduct");
		List<Object> productImage = (List<Object>) session.getAttribute("productImage");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int productID = product.getProductID();
		// 把商品編號、商品、圖片、購買數量放入陣列中
		List<Object> selectedProduct = new ArrayList<>();
		selectedProduct.add(productID);
		selectedProduct.add(product);
		selectedProduct.add(productImage);
		selectedProduct.add(quantity);
		boolean productExist = false;
		// 加入購物車 如果購物車內已經有該商品就增加數量
		for (List<Object> orderDetail : cart) {
			if (productID == (int) orderDetail.get(0)) {
				int oldQuantity = (int) orderDetail.get(3);
				orderDetail.set(3, oldQuantity + quantity);
				productExist = true;
				break;
			}
		}
		if (!productExist)
			cart.add(selectedProduct);
		session.setAttribute("cart", cart);
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "DirectPurchase":
				request.getRequestDispatcher("/four/products/jsp/mall/ShoppingCart.jsp").forward(request, response);
				break;
			case "AddToCart":
				request.setAttribute("inTheCart", true);
				request.getRequestDispatcher("/four/products/jsp/mall/ProductDetail.jsp").forward(request, response);
				break;
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

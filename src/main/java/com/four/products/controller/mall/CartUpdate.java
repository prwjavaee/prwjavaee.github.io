package com.four.products.controller.mall;

import java.io.IOException;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartUpdate")
public class CartUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 取得cart
		List<List<Object>> cart = (List<List<Object>>) session.getAttribute("cart");
		// 如果購物車不是空的就更新購物車
		String orderData = request.getParameter("orderData");
		// (1)從orderData取得商品資訊
		JsonObject jsonObject = JsonParser.parseString(orderData).getAsJsonObject();
		JsonArray orderItems = jsonObject.getAsJsonArray("orderItems");
		for (JsonElement item : orderItems) {
			JsonObject orderItem = item.getAsJsonObject();
			int productID = orderItem.get("productID").getAsInt();
			int quantity = orderItem.get("quantity").getAsInt();
			int productPrice = orderItem.get("productPrice").getAsInt();
			for (List<Object> product : cart) { // 把購物車的資訊放到session內的購物車內
				if ((int) product.get(0) == productID) {
					product.set(3, quantity);
					product.add(productPrice);
				}
			}
		}
		int total = jsonObject.get("orderTotalPrice").getAsInt(); // (2)從orderData取得訂單總金額
		session.setAttribute("totalOrderPrice", total);
		try {
			request.getRequestDispatcher("/CatchOrder").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

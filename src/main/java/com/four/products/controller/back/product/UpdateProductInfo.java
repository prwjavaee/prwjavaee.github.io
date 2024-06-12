package com.four.products.controller.back.product;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.four.products.bean.Product;
import com.four.products.dao.DAO;
import com.four.products.dao.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProductInfo")
public class UpdateProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int selectedProductID = Integer.parseInt(request.getParameter("productID"));
		String categoryName = request.getParameter("categoryName");
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
		Date listingDate = null;
		try {
			listingDate = format.parse(request.getParameter("listingDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int stock = Integer.parseInt(request.getParameter("stock"));
		String productFeatures = request.getParameter("feature");
		Product updatedProduct = new Product(selectedProductID, categoryName, productName, price, listingDate, stock, productFeatures);
		DAO<Product> producDAO = new ProductDAO();
		boolean updateStatus = producDAO.update(updatedProduct);
		request.setAttribute("status", updateStatus);
		try {
			request.getRequestDispatcher("/GetInfoBeforeUpdate?"+selectedProductID).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

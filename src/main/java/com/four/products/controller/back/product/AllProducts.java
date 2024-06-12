package com.four.products.controller.back.product;

import java.io.IOException;
import java.util.List;

import com.four.products.bean.Product;
import com.four.products.bean.ProductImage;
import com.four.products.dao.DAO;
import com.four.products.dao.ProductDAO;
import com.four.products.dao.ProductImageDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AllProducts")
public class AllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		DAO<Product> productDAO = new ProductDAO();
		DAO<ProductImage> imageDao = new ProductImageDAO();

		List<Product> allProducts = productDAO.searchAll();
		List<ProductImage> allImages = imageDao.searchAll();
		request.setAttribute("allProducts", allProducts);
		request.setAttribute("allImages", allImages);
		try {
			request.getRequestDispatcher("/four/products/jsp/product/AllProducts.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

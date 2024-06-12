package com.four.products.controller.back.product;

import java.io.IOException;
import java.util.List;

import com.four.products.bean.ProductCategory;
import com.four.products.dao.DAO;
import com.four.products.dao.ProductCategoryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchAllCategory")
public class SearchAllCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		DAO<ProductCategory> productcategoryDAO = new ProductCategoryDAO();
		List<ProductCategory> allCategories = productcategoryDAO.searchAll();
		request.setAttribute("allCategories", allCategories);
		if(request.getAttribute("status") == null) {
			request.setAttribute("status", false);
		}
		try {
			request.getRequestDispatcher("/four/products/jsp/product/InsertProduct.jsp").forward(request, response);			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

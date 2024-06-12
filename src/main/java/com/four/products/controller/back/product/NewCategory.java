package com.four.products.controller.back.product;

import java.io.IOException;

import com.four.products.bean.ProductCategory;
import com.four.products.dao.DAO;
import com.four.products.dao.ProductCategoryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NewCategory")
public class NewCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String categoryName = request.getParameter("category");

		ProductCategory category = new ProductCategory();
		category.setCategoryName(categoryName);
		DAO<ProductCategory> productcategoryDAO = new ProductCategoryDAO();
		productcategoryDAO.insert(category);
		request.setAttribute("categoryAdded", true);
		try {
			request.getRequestDispatcher("/SearchAllCategory").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

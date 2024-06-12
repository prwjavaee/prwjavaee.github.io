package com.four.products.controller.back.product;

import java.io.IOException;
import java.util.List;

import com.four.products.bean.Product;
import com.four.products.dao.DAO;
import com.four.products.dao.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FuzzySearch")
public class FuzzySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String keyword = "%"+request.getParameter("query")+"%";
		DAO<Product> productDAO = new ProductDAO();
		List<Product> searchResult = productDAO.fuzzySearch(keyword);
		request.setAttribute("productsFound", searchResult);
		try {
			request.getRequestDispatcher("/four/products/jsp/product/QueryResult.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

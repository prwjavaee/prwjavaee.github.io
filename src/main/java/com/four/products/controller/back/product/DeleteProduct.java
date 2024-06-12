package com.four.products.controller.back.product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String[] deleteProductIDs = request.getParameterValues("delete");
		List<Integer> deleteIDsList = Arrays.stream(deleteProductIDs)
											.map(id -> Integer.valueOf(id))
											.collect(Collectors.toList());
		DAO<Product> productDAO = new ProductDAO();
		DAO<ProductImage> imageDao = new ProductImageDAO();
		imageDao.delete(deleteIDsList);
		boolean deleteStatus = productDAO.delete(deleteIDsList);
		request.setAttribute("status", deleteStatus);
		try {
			request.getRequestDispatcher("/AllProducts").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

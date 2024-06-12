package com.four.products.controller.back.product;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import com.four.products.bean.Product;
import com.four.products.dao.DAO;
import com.four.products.dao.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/InsertProduct")
@MultipartConfig
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String productName = request.getParameter("productName");
		String categoryName = request.getParameter("productCategory");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Date listingDate = new Date();
		byte[] imageByte = null;
		try {
			Part part = request.getPart("image");
			InputStream inputStream = part.getInputStream();
			imageByte = inputStream.readAllBytes();
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		
		String feature = request.getParameter("feature");
		Product product = new Product(categoryName, productName, price, listingDate, quantity, feature);
		DAO<Product> productDAO = new ProductDAO();
		boolean insertStatus = productDAO.insert(product);
		InsertImage.searchAndInsert(imageByte);
		
		request.setAttribute("status", insertStatus);			
		try {
			request.getRequestDispatcher("/SearchAllCategory").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
//		InsertImage.searchAndInsert(imagePaths);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

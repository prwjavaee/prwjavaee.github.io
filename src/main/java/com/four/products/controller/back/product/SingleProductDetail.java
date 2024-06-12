package com.four.products.controller.back.product;

import java.io.IOException;
import java.util.Base64;

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

@WebServlet("/SingleProductDetail")
public class SingleProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int selectedProductID = Integer.parseInt(request.getParameter("productID"));
		DAO<Product> producDAO = new ProductDAO();
		DAO<ProductImage> imageDAO = new ProductImageDAO();
		Product searchResult = producDAO.singleSearch(selectedProductID);
		ProductImage imageSearchResult = imageDAO.singleSearch(selectedProductID);
		
		String base64Image = Base64.getEncoder().encodeToString(imageSearchResult.getImage());

		request.setAttribute("selectedProduct", searchResult);
		request.setAttribute("imageData", base64Image);
		
		try {
			request.getRequestDispatcher("/four/products/jsp/product/SingleProductDetail.jsp").forward(request, response);				
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

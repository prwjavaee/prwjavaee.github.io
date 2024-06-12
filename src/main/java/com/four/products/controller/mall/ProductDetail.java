package com.four.products.controller.mall;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int selectedProductID = Integer.parseInt(request.getParameter("productID"));
		DAO<Product> producDAO = new ProductDAO();
		DAO<ProductImage> imageDAO = new ProductImageDAO();
		Product searchResult = producDAO.singleSearch(selectedProductID);
		ProductImage searchResultImg = imageDAO.singleSearch(selectedProductID);
		
		String base64Image = Base64.getEncoder().encodeToString(searchResultImg.getImage());
		List<Object> base64ImageData = Arrays.asList(searchResultImg.getImageID(), searchResultImg.getProductID(), base64Image);
		HttpSession session = request.getSession();
		session.setAttribute("selectedProduct", searchResult);
		session.setAttribute("productImage", base64ImageData);
		request.setAttribute("inTheCart", false);
		try {
			request.getRequestDispatcher("/four/products/jsp/mall/ProductDetail.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

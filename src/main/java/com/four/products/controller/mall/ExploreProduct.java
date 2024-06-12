package com.four.products.controller.mall;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/ExploreProduct")
public class ExploreProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String memNo = session.getAttribute("memberNo").toString();
		session.setAttribute("memberNo", memNo);
		
		DAO<Product> productDAO = new ProductDAO();
		DAO<ProductImage> imageDao = new ProductImageDAO();

		List<Product> allProducts = productDAO.searchAll();
		List<ProductImage> allImages = imageDao.searchAll();
		List<List<Object>> allBase64Images = new ArrayList<>();
		for (ProductImage productImage : allImages) {
			String base64Image = Base64.getEncoder().encodeToString(productImage.getImage());
			List<Object> data = Arrays.asList(productImage.getImageID(), productImage.getProductID(), base64Image);
			allBase64Images.add(data);
		}
		
		request.setAttribute("allProducts", allProducts);
		request.setAttribute("allImages", allBase64Images);
		try {
			request.getRequestDispatcher("/four/products/jsp/mall/ExploreProducts.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

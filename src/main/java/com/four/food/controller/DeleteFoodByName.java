package com.four.food.controller;

import java.io.IOException;

import com.four.food.dao.FoodDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFoodByName")
public class DeleteFoodByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String foodName = request.getParameter("foodName");
		FoodDao foodDao = new FoodDao();
		
		//使用foodDao的.deleteByName()方法
        foodDao.deleteByName(foodName);
		request.getRequestDispatcher("/ShowFood").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/four/food/jsp/ShowFood.jsp");
        
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}

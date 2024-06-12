package com.four.food.controller;

import java.io.IOException;

import com.four.food.dao.FoodDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFoodByID")
public class DeleteFoodByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String foodID = request.getParameter("foodID");
		FoodDao foodDao = new FoodDao();

		// 使用foodDao的.deleteByID()方法
		foodDao.deleteByID(Integer.parseInt(foodID));
		request.getRequestDispatcher("/ShowFood").forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}

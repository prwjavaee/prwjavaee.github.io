package com.four.food.controller;

import java.io.IOException;
import java.util.List;

import com.four.food.bean.FoodBean;
import com.four.food.dao.FoodDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ShowFood")
public class ShowFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			FoodDao foodDao = new FoodDao();
			List<FoodBean> foodList = foodDao.queryAll();
			request.setAttribute("foodList", foodList);
			request.getRequestDispatcher("/four/food/jsp/ShowFood.jsp").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

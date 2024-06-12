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

@WebServlet("/QueryFoodByName")
public class QueryFoodByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String foodName = request.getParameter("foodName");
		// 查詢不可為空白
		if (foodName != null && !foodName.isEmpty()) {

			FoodDao foodDao = new FoodDao();
			List<FoodBean> foods = foodDao.queryByFoodName(foodName);

			request.setAttribute("foods", foods);
			request.getRequestDispatcher("/four/food/jsp/QueryFoodByName.jsp").forward(request, response);
		} else {
			// 如果食品名稱空白 -->回整張頁面
			request.getRequestDispatcher("/ShowFood").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}

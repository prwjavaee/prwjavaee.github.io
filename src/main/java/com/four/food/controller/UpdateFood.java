package com.four.food.controller;

import java.io.IOException;

import com.four.food.bean.FoodBean;
import com.four.food.dao.FoodDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateFood")
public class UpdateFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 取食品資料
		int foodID = Integer.parseInt(request.getParameter("foodID"));
		String newName = request.getParameter("foodName");
		float newProtein = Float.parseFloat(request.getParameter("protein"));
		float newCarbohydrates = Float.parseFloat(request.getParameter("carbohydrates"));
		float newFat = Float.parseFloat(request.getParameter("fat"));
		float newTotalCaloriesPer100g = Float.parseFloat(request.getParameter("totalCaloriesPer100g"));	

		FoodBean updatedFood = new FoodBean();
			updatedFood.setFoodID(foodID);
			updatedFood.setFoodName(newName);
			updatedFood.setProtein(newProtein);
			updatedFood.setCarbohydrates(newCarbohydrates);
			updatedFood.setFat(newFat);
			updatedFood.setTotalCaloriesPer100g(newTotalCaloriesPer100g);
			
			FoodDao foodDao = new FoodDao();
			foodDao.updateByFoodID(updatedFood);
			request.getRequestDispatcher("/ShowFood").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}

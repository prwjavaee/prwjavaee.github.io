package com.four.food.controller;

import java.io.IOException;

import com.four.food.bean.FoodBean;
import com.four.food.dao.FoodDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertFood")
public class InsertFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String foodName = request.getParameter("foodName");
		float protein = Float.parseFloat(request.getParameter("protein"));
		float carbohydrates = Float.parseFloat(request.getParameter("carbohydrates"));
		float fat = Float.parseFloat(request.getParameter("fat"));

		FoodBean foodBean = new FoodBean();
		foodBean.setFoodName(foodName);
		foodBean.setProtein(protein);
		foodBean.setCarbohydrates(carbohydrates);
		foodBean.setFat(fat);

		// １００克總熱量公式：蛋白質 * 4 + 碳水化合物 * 4 + 脂肪 * 9
		//String.format("%.2f", 值) -->以字串形式 取小數點後兩位
		//parseFloat() 將字串轉換型為以十進位表示的浮點數
        float totalCaloriesPer100g = Float.parseFloat(String.format("%.2f", (protein * 4 + carbohydrates * 4 + fat * 9)))   ;     
		foodBean.setTotalCaloriesPer100g(totalCaloriesPer100g);

		FoodDao foodDao = new FoodDao();

			foodDao.insert(foodBean);
			request.getRequestDispatcher("/ShowFood").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/four/food/jsp/ShowFood.jsp");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}

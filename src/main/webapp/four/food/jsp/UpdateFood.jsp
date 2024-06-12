<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*, com.four.food.dao.FoodDao, com.four.food.bean.FoodBean" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>更新食品</title>

		<!-- css路徑 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/food/css/style.css" />
		<!-- CND路徑 -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
	   	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">

</head>

<body id="foodList">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div align="center" class="main-block">
		<h1>更 新 食 品 資 料</h1>
		<h2>以100克含量紀錄</h2>
		<% int foodID=Integer.parseInt(request.getParameter("foodID")); FoodDao foodDao=new FoodDao(); FoodBean
			food=foodDao.queryByFoodID(foodID); %>
			<form action="<%=request.getContextPath()%>/UpdateFood" method="post" accept-charset="UTF-8"
				class="insertFood">
				<input type="hidden" name="foodID" value="<%=food.getFoodID()%>" />
				<label for="foodName">食品名稱：</label><br> 
				<input type="text" id="foodName" name="foodName" value="<%=food.getFoodName()%>" required /><br /> 
				<label for="protein">蛋白值含量：</label><br> 
				<input type="number" step="0.1" id="protein" name="protein" value="<%=food.getProtein()%>" required /><br /> 
				<label for="carbohydrates">碳水化合物含量：</label><br> 
				<input type="number" step="0.1" id="carbohydrates" name="carbohydrates" value="<%=food.getCarbohydrates()%>"required /><br /> 
				<label for="fat">脂肪含量：</label><br> 
				<input type="number" step="0.1" id="fat" name="fat" value="<%=food.getFat()%>" required /><br /> 
				<label for="totalCaloriesPer100g">總熱量：</label><br> 
				<input type="number" step="0.1" id="totalCaloriesPer100g" name="totalCaloriesPer100g" value="<%=food.getTotalCaloriesPer100g()%>" required /><br /> <br>
				<button type="submit" class="updatebtn">更新</button>
			</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>

</html>
<%@ page import="com.four.food.bean.FoodBean" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>食品列表</title>
	<!-- css路徑 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/food/css/style.css" />
	<!-- CND路徑 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
	<!-- 動畫路徑 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/food/css/animate.css" />
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>

<body id="foodList">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div align="center" class="main-block">
		<h1>食 品 列 表</h1>
		<h2>此為每100克含量</h2>
		<div class="insertbtn">
			<form action="${pageContext.request.contextPath}/four/food/jsp/InsertFood.jsp" method="get">
				<button type="submit"><i class="fa-solid fa-cart-arrow-down"></i>新增</button>
			</form>
		</div>
		<table border="1" class="foodTable">
			<tr>
				<th>編號</th>
				<th>名稱</th>
				<th>蛋白質含量</th>
				<th>碳水化合物含量</th>
				<th>脂肪含量</th>
				<th>總熱量</th>
				<th>刪除</th>
				<th>更新</th>
			</tr>

			<c:forEach items="${foodList}" var="food">
				<tr>
					<td>${food.foodID}</td>
					<td>${food.foodName}</td>
					<td>${food.protein}</td>
					<td>${food.carbohydrates}</td>
					<td>${food.fat}</td>
					<td>${food.totalCaloriesPer100g}</td>

					<td><a href="${pageContext.request.contextPath}/DeleteFoodByID?foodID=${food.foodID}" class="Idelete">
							<i
								class="fa-solid fa-trash-can fa-2xl"></i>
						</a>
					</td>
					<td><a href="${pageContext.request.contextPath}/four/food/jsp/UpdateFood.jsp?foodID=${food.foodID}&foodName=${food.foodName}&protein=${food.protein}&carbohydrates=${food.carbohydrates}&fat=${food.fat}&totalCaloriesPer100g=${food.totalCaloriesPer100g}"
							class="Iupdate">
							<i
								class="fa-solid fa-square-pen fa-2xl"></i>
						</a></td>
				</tr>
			</c:forEach>

		</table>
		<!-- 食品查詢 -->
		<br>
		<div class="querybtn">
			<form action="${pageContext.request.contextPath}/QueryFoodByName" method="post">
				<label for="foodName">食品名稱 :</label><br>
				<input type="text" id="foodName" name="foodName">
				<input type="submit" value="查詢">
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>
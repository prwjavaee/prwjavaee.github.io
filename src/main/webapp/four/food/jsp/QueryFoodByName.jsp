<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.four.food.bean.FoodBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>查詢結果</title>
	<!-- css路徑 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/food/css/style.css" />
	<!-- CND路徑 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>

<body id="foodList">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<h1>查詢結果</h1>
		<c:if test="${not empty foods}">
			<table border="1" class="foodTable">
				<tr>
					<th>名稱</th>
					<th>蛋白質含量</th>
					<th>碳水化合物含量</th>
					<th>脂肪含量</th>
					<th>總熱量</th>
				</tr>
				<c:forEach items="${foods}" var="food">
					<tr>
						<td>${food.foodName}</td>
						<td>${food.protein}</td>
						<td>${food.carbohydrates}</td>
						<td>${food.fat}</td>
						<td>${food.totalCaloriesPer100g}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty foods}">
			<!-- foods為null -->
			<p>沒有找到符合條件的食品。</p>
		</c:if>
		<form action="${pageContext.request.contextPath}/ShowFood" method="post" class="backbtnForm">
			<button type="submit" class="backbtn"><i class="fa-solid fa-rotate-left"></i>返回食品列表</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>

</html>
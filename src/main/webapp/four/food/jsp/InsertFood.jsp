<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="java.util.*, com.four.food.dao.FoodDao, com.four.food.bean.FoodBean" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增食品</title>
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
        <h1>新 增 食 品</h1>
        <h2>以100克含量紀錄</h2>
        <form action="${pageContext.request.contextPath}/InsertFood" method="post" class="insertFood">
            <label for="foodName">食品名稱:</label><br>
            <input type="text" id="foodName" name="foodName" value="全家黑胡椒雞柳" required><br>

            <label for="protein">蛋白質含量:</label><br>
            <input type="text" id="protein" name="protein" value="11.2" required><br>

            <label for="carbohydrates">碳水化合物含量:</label><br>
            <input type="text" id="carbohydrates" name="carbohydrates" value="9.8" required><br>

            <label for="fat">脂肪含量:</label><br>
            <input type="text" id="fat" name="fat" value="4.4" required><br>

            <input type="submit" value="提交">
        </form>
        <br>
        <button onclick="window.history.back()" class="backbtn">
            <i class="fa-solid fa-rotate-left"></i>返回食品列表
        </button>
        <!-- 回上一頁 -->
    </div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>

</html>
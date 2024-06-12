<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.four.article.bean.ArticleBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.catalina.webresources.EmptyResourceSet"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改資料</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/four/article/css/UpdateArticle.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
	</head>
	<body id="main-body">
		<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
		<div class="main-container main-block">
			<h2>修改資料</h2>
			<form action="UpdateArticle2" method="get">
				文章編號 : <input type="number" name="articleID" readonly value="${updateArticle.articleID}"><br>
				文章標題 : <input type="text" name="articleTitle" required value="${updateArticle.articleTitle}"><br>
				<label for="tag">文章標籤 : </label>
				<select name="tag">
					<option value="課程心得">課程心得</option>
					<option value="飲食分享">飲食分享</option>
					<option value="問題討論">問題討論</option>
					<option value="其他">其他</option>
				</select><br>
				文章內容 : <textarea name="articleContent" required >${updateArticle.articleContent}</textarea><br>
				<div class="button-container">
					<button type="button" onclick="goBack()">上一頁</button>
					<button type="submit" id="btn">修改</button>
				</div>
			</form>
		</div>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
		<script>
			function goBack() {
				window.history.back();
			}
		</script>
	</body>
</html>
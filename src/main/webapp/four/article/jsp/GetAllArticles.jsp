<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.four.article.bean.ArticleBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.catalina.webresources.EmptyResourceSet"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>文章資料</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/four/article/css/GetAllArticles.css">
	   	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
	</head>
	<body id="main-body">
		<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
		<div class="main-container  main-block">
			<h2 class="article-title">文章資料</h2>
			<div class="button-container">
				<form action="${pageContext.request.contextPath}/GetAllArticles" method="get" id="all-article-form">
        			<button type="submit" id="all-article-button">全部文章</button>
   				</form>
				<a href="${pageContext.request.contextPath}/four/article/jsp/InsertArticle.jsp ">新增文章</a>
       	 		<form action="${pageContext.request.contextPath}/GetArticlesByTitle" method="get" id="fuzzy-query-form">
					<select class="query-input">
						<option>標題</option>
					</select>
         			<input type="text" name="title" class="query-input" id="query-input">
            		<input type="submit" value="查詢">
       	 		</form>
			</div>
			<div class="table-container">
				<table border="1">
					<tr style="background-color:#a8fefa">
						<th>文章編號<th>會員編號<th>顯示狀態<th>發文時間<th>標籤<th>文章標題<th>文章內容<th>	<th>		
					<c:forEach items="${allArticles}" var="article">
						<tr>
							<td>${article.articleID}</td>
							<td>${article.memberID}</td>
							<td>${article.articleDisplay eq 0? "不顯示" : "顯示"}</td>
							<td>${article.postTime}</td>
							<td>${article.tag}</td>
							<td>${article.articleTitle}</td>
							<td>${article.articleContent}</td>
							<td>
							<form action="${pageContext.request.contextPath}/UpdateArticle1" id="form">
								<input id="inputValue" type="hidden" name="articleID" value="${article.articleID}">
        	 					<button type="submit" >修改</button>
   							</form></td>
							<td>
							<form action="${pageContext.request.contextPath}/DeleteArticle" method="get">
		 						<input type="hidden" name="articleID" value="${article.articleID}">
        	 					<button type="submit">刪除</button>
   							</form></td>				
   						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
	</body>
</html>
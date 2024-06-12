<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.coach.bean.CoachBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>教練資料</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/coach/css/CoachPage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="coachpage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="coachPageContainer">
			<div class="btnLike">
				<a href="${pageContext.request.contextPath}/CoachGetAll" class="link-btn2">查詢教練</a>
				<a href="javascript:history.go(-1)" class="link-btn4">回上一頁</a>
			</div>
		    <div class="coachProfileHeader">
		        <img src="${pageContext.request.contextPath}/four/coach/images/${coach.coachPic}" alt="教練照片">
		        <div class="coachInfo">
		            <h2>${coach.coachName}</h2>
		            <div class="coachDetails">
				        <p>教練編號:${coach.coachId} </p>
				        <p>教練簡介:${coach.coachProfile}</p>
		            </div>
		        </div>
		    </div>
		    <div class="coachTec">
		    	<h2>教學課程項目</h2>
		    	<ul>
		    	<c:forEach var="course" items="${courses}">
	            	<li><a href="${pageContext.request.contextPath}/CourseGetById?courseId=${course.courseId}">${course.courseName}</a></li>
		            <li>${course.courseProfile}</li>
		    	</c:forEach>
		    	</ul>
		    </div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.course.bean.CourseBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>課程資料</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/course/css/CoursePage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="coursepage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="coursePageContainer">
			<div class="btnLike">
				<a href="${pageContext.request.contextPath}/CourseUpdate?courseId=${course.courseId}" class="link-btn1">修改資料</a>
				<a href="${pageContext.request.contextPath}/CourseGetAll" class="link-btn2">查詢課程</a>
				<a href="${pageContext.request.contextPath}/ScheduleShowByCourseId?courseId=${course.courseId}" class="link-btn3">查詢課表</a>
			</div>
		    <h2>課程資料</h2>
			<div class="courseInfo">
			    <div>課程編號: ${course.courseId}</div>
			    <div>課程名稱: ${course.courseName}</div>
			    <div>課程資料: ${course.courseProfile}</div>
			    <div>教練編號: ${course.coachId}</div>
		        <div>教練姓名:<a href="${pageContext.request.contextPath}/CoachGetById?coachId=${course.coachId}">${course.coachName}</a></div>
			    <div>課表顯示: <a href="${pageContext.request.contextPath}/ScheduleShowByCourseId?courseId=${course.courseId}">點我</a></div>
			    <div>課表資料: <a href="${pageContext.request.contextPath}/ScheduleGetById?courseId=${course.courseId}">點我</a></div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>
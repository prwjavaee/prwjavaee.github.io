<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.schedule.bean.ScheduleBean, java.lang.SuppressWarnings"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/schedule/css/SchedulePage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="schedulepage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="scheduleTableContainer">
			<h2>課表資料</h2>
			<div class="btnLike">
				<a href="${pageContext.request.contextPath}/CourseGetById?courseId=${courseId}" class="link-btn1">回到課程</a>
				<a href="${pageContext.request.contextPath}/ScheduleShowByCourseId?courseId=${courseId}" class="link-btn2">顯示課表</a>
			</div>
			<form method="post" action="${pageContext.request.contextPath}/ScheduleInsert">
			    <table class="scheduleTable">
			        <tr><th>課表編號</th><th>課程編號</th><th>星期</th><th>時間</th><th>刪除</th></tr>
			        <c:forEach var="schedule" items="${schedules}">
			            <tr>
			                <td>${schedule.scheduleId}</td>
			                <td>${schedule.courseId}</td>
			                <td>${schedule.weekday}</td>
			                <td>${schedule.daytime}</td>
			                <td><a href="${pageContext.request.contextPath}/ScheduleDelete?scheduleId=${schedule.scheduleId}&courseId=${schedule.courseId}">刪除</a></td>
			            </tr>
			        </c:forEach>
			        <tr>
			            <td>&nbsp;</td>
			            <td><input type="text" id="courseId" name="courseId" value="${courseId}" readonly ></td>
			            <td><input type="text" id="weekday" name="weekday"></td>
			            <td><input type="text" id="daytime" name="daytime"></td>
			            <td><input type="submit" value="新增"></td>
			        </tr>
			    </table>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>

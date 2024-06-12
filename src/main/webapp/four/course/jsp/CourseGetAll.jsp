<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.course.bean.CourseBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
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
		<div class="courseTableContainer">
			<h2>課程資料</h2>
			<div class="btnLike">
				<a href="${pageContext.request.contextPath}/CourseGetAll" class="link-btn1">查詢全部</a>
				<a href="${pageContext.request.contextPath}/CoachGetAll" class="link-btn2">查詢教練</a>
				<a href="${pageContext.request.contextPath}/ScheduleShowAll" class="link-btn3">課表顯示</a>
				<a href="${pageContext.request.contextPath}/ScheduleGetAll" class="link-btn4">課表資料</a>
			</div>
			<div class="coursefunction">
	   			<a href="${pageContext.request.contextPath}/four/course/jsp/CourseInsert.jsp" id="newcoursebtn">新增課程</a>
	   			<form method="post" action="${pageContext.request.contextPath}/CourseGetByLike">
	           		<input type="text" placeholder="輸入關鍵字" name="likeword"/>
	           		<input type="submit" value="查詢"/>
	   			</form>
			</div>
			<table	class="courseTable">
			    <tr><th>課程編號<th>課程名稱<th>課程資料<th>教練編號<th>教練姓名<th>修改<th>刪除</tr>
			    <c:forEach var="course" items="${courses}">
			        <tr>
			            <td>${course.courseId}</td>
			            <td><a href="${pageContext.request.contextPath}/CourseGetById?courseId=${course.courseId}">${course.courseName}</a></td>
			            <td>${course.courseProfile}</td>
			            <td>${course.coachId}</td>
			            <td><a href="${pageContext.request.contextPath}/CoachGetById?coachId=${course.coachId}">${course.coachName}</a></td>
			            <td><a href="${pageContext.request.contextPath}/CourseUpdate?courseId=${course.courseId}" class="button-like">修改</a></td>
			            <td><a href="${pageContext.request.contextPath}/CourseDelete?courseId=${course.courseId}" class="button-like">刪除</a></td>
			        </tr>
			    </c:forEach>
			</table>
			<div id="pgbtn"></div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
	<script>
	$(document).ready(function() {
	    var rowsPerPage = 10;
	    var rows = $('.courseTable tr').not(':first-child');
	    var totalPages = Math.ceil(rows.length / rowsPerPage);
	    for (var i = 1; i <= totalPages; i++) {
	        var button = $('<button>').text(i);
	        button.click(function() {
	            showPage($(this).text());
	        });
	        $('#pgbtn').append(button);
	    }
	    showPage(1);
	    function showPage(pageNumber) {
	        var startIndex = (pageNumber - 1) * rowsPerPage;
	        var endIndex = startIndex + rowsPerPage;
	        rows.hide().slice(startIndex, endIndex).show();
	    }
	});
	</script>
</body>
</html>

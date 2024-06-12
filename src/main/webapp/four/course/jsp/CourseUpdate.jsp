<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.course.bean.CourseBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/course/css/CoursePage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="coursepage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="courseModifyContainer">
			<div class="btnLike">
				<a href="javascript:history.go(-1)" class="link-goback">返回上頁</a>
			</div>
		    <form method="post" action="${pageContext.request.contextPath}/CourseUpdate2">
		        <p>課程編號: <input type="text" name="courseId" value="${course.courseId}" class="courseModifyTextArea" /></p>
		        <p>課程名稱: <input type="text" name="courseName" value="${course.courseName}" class="courseModifyTextArea" /></p>
		        <p>課程簡介: <textarea name="courseProfile"class="courseModifyTextArea">${course.courseProfile}</textarea> </p>
		        <p>教練編號: <input type="text" name="coachId" value="${course.coachId}" class="courseModifyTextArea" /></p>
		        <input type="submit" value="確定" class="submit courseModifyTextArea"/>
		    </form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>
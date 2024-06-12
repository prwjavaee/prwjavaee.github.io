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
		    <h2>插入課程資料</h2>
		    <form method="post" action="${pageContext.request.contextPath}/CourseInsert">
				<p>輸入課程名稱 : <input type="text" name="courseName" value="無情訓練：鋼鐵挑戰" class="courseModifyTextArea" /></p>
				<p>輸入課程簡介 : <textarea name="courseProfile" placeholder="輸入課程簡介" class="courseModifyTextArea">"無情訓練：鋼鐵挑戰" 是一個極度挑戰性的訓練課程，旨在將您推向極限並超越它。通過結合高強度訓練、循環訓練和耐力挑戰，這個課程將塑造您的身體，提高您的耐力和力量，並讓您超越自己的極限。</textarea> </p>
		        <p>輸入教練編號 : <input type="text" name="coachId" value="2006" class="courseModifyTextArea" /></p>
		        <input type="submit" value="確定" class="submit courseModifyTextArea"/>
		    </form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>


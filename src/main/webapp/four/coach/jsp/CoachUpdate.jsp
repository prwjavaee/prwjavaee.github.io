<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.coach.bean.CoachBean"%>
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
		<div class="coachModifyContainer">
			<div class="btnLike">
				<a href="javascript:history.go(-1)" class="link-goback">回上一頁</a>
			</div>
			<h2>更新資料</h2>
		    <form method="post" action="${pageContext.request.contextPath}/CoachUpdate2" enctype="multipart/form-data">
		        <p>教練編號: <input type="text" name="coachId" value="${coach.coachId}" class="coachModifyTextArea" /></p>
		        <p>教練姓名: <input type="text" name="coachName" value="${coach.coachName}" class="coachModifyTextArea" /></p>
		        <p>教練職稱: <input type="text" name="coachJob" value="${coach.coachJob}" class="coachModifyTextArea" /></p>
		        <p>教練簡介: <textarea name="coachProfile"class="coachModifyTextArea">${coach.coachProfile}</textarea> </p>
		        <p class="coachModifyPic">教練照片 : <input type="file" name="coachPic" value="${coach.coachPic}" /></p>
		        <input type="submit" value="確定" class="submit coachModifyTextArea"/>
		    </form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>
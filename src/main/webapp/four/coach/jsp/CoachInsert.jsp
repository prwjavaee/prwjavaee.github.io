<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.coach.bean.CoachBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/coach/css/CoachPage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="coachpage">
	<%@ include file="../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="coachModifyContainer">
			<div class="btnLike">
				<a href="javascript:history.go(-1)" class="link-goback">回上一頁</a>
			</div>
		    <h2>新增教練資料</h2>
		    <form method="post" action="${pageContext.request.contextPath}/CoachInsert" enctype="multipart/form-data">
		        <p>輸入教練姓名 : <input type="text" name="coachName" value="Noel Deyzel" class="coachModifyTextArea" /></p>
		        <p>輸入教練職稱 : <input type="text" name="coachJob" value="專業健美教練" class="coachModifyTextArea" /></p>
		        <p>輸入教練簡介 : <textarea name="coachProfile" placeholder="輸入教練簡介" class="coachModifyTextArea">擁有16年健身產業經驗的健美運動員，我熱衷於激勵他人，提供專業建議並在他們的健美之旅和生活中給予幫助。我致力於不僅幫助他們達到健身目標，還希望在他們的生活中帶來積極的改變。 </textarea> </p>
		        <p class="coachModifyPic">輸入照片 : <input type="file" name="coachPic"/></p>
		        <input type="submit" value="確定" class="submit coachModifyTextArea"/>
		    </form>
	    </div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>
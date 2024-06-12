<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
<title>新增會員資料</title>
</head>
<body style="background-color:#fdf5e6">
<%@ include file="NavSide.jsp" %>
	<main class="main-block">
		<div align="center">
			<h2 class="space">新增會員資料</h2><p class="empty"></p>
			<div class="table-container">
				<form method="post" action="../../../Insert">
					<table class="member-table">
						<tr><td>姓名：<td><input type="text" name="memName" required/>
						<tr><td>Email：<td><input type="text" name="memEmail" required/>
						<tr><td>密碼：<td><input type="password" name="memPassword" />
						<tr><td>性別：<td>
							<select name="gender" id="gender" required>  <!--下拉式選單-->
								<option value="0">男性</option>
								<option value="1">女性</option>
							</select>
						<tr><td>生日：<td><input type="date" name="birth" value="1990-01-01">
						<tr><td>電話：<td><input type="text" name="phone" required/>
						<tr><td>暱稱：<td><input type="text" name="nickName" />
						<!-- <tr><td>上傳個人圖片：<td><input type="file" name="memPic" /> -->
					</table><br>
					<button type="submit">確定</button>
				</form>
			</div>
			<p class="empty"></p>
			<a class="abtn" href="${pageContext.request.contextPath}/GetAllMems" >所有會員資料</a><br>
		</div>
	</main>

	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/four/memberAdm/js/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>

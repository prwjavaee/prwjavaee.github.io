<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增文章</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/four/article/css/InsertArticle.css">
	   	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
	</head>
	<body id="main-body">
		<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
		<div class="main-container main-block">
			<h2>新增文章</h2>
			<form action="${pageContext.request.contextPath}/InsertArticle" method="get" onsubmit="fillLocalTime()">
				會員編號 : <input type="text" name="memberID" pattern="\d{8}" placeholder="輸入8位數字" required><br>
				文章標題 : <input type="text" name="articleTitle" required ><br>
				發文時間 : <input type="text" name="postTime" id="postTime" readonly value="預設為輸入時系統時間"><br>
				<label for="tag">文章標籤 : </label>
				<select name="tag">
					<option value="課程心得">課程心得</option>
					<option value="飲食分享">飲食分享</option>
					<option value="問題討論">問題討論</option>
					<option value="其他">其他</option>
				</select><br>
				<label for="articleDisplay">顯示狀態 : </label>
				<select name="articleDisplay">
					<option value="1">顯示</option>
					<option value="0">隱藏</option>
				</select><br>
				文章內容 : <textarea name="articleContent" required></textarea><br>
				<div class="button-container">
					<button type="button" onclick="goBack()">上一頁</button>
					<button type="submit">新增</button>
				</div>
				
			</form>
		</div>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
		<script>
			function fillLocalTime() {
   				// 取得當前時間
    			const now = new Date();
    			// 將本地時間格式化為 yyyy-mm-dd HH:MM:SS 格式
    			const formattedTime = now.toISOString().slice(0, 19).replace('T', ' ');
    			// 將格式化後的時間填入發文時間欄位
    			document.getElementsByName("postTime")[0].value = formattedTime;
			}
			function goBack() {
				window.history.back();
			}
		</script>
	</body>
</html>
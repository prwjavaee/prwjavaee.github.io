<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.four.memberAdm.bean.MemberBean, java.util.Base64" %>

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

<title>會員資料</title>
</head>
<body style="background-color:#fdf5e6">
<%@ include file="NavSide.jsp" %>
	<main class="main-block">
		<div align="center">
			<h2>會員資料</h2><p class="empty"></p>
			<%-- <jsp:useBean id="member" scope="request" class="com.four.memberAdm.bean.MemberBean" /> --%>
			<div class="table-container">
				<table class="member-table">
					<% MemberBean member = (MemberBean)request.getAttribute("member"); %>
					<tr style="border-bottom: 1px solid black"><td>會員編號<td><%= member.getMemNo() %>
					<tr><td>姓名<td><%= member.getMemName() %>
					<tr><td>Email<td><%= member.getMemEmail() %>
					<tr><td>密碼<td><%= member.getMemPassword() %>
					<tr><td>性別<td><%= member.getGender() == 0 ? "男性" : "女性" %>
					<tr><td>生日<td><%= member.getBirth() %>
					<tr><td>電話<td><%= member.getPhone() %>
					<tr><td>註冊日期<td><%= member.getRegDate() %>
					<tr><td>狀態<td><%= member.getStatus() == 0 ? "未驗證" : (member.getStatus() == 1 ? "正常" : "封鎖") %>
					<tr><td>暱稱<td><%= member.getNickName() %>
					<tr><td>個人圖片<td>
						<% if (member.getMemPic() != null) { %>
						<img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(member.getMemPic()) %>" width="100"/>
						<% } else {
		                        out.print("");
		                } %> </td>
				</table>
			</div>
			
			<a class="abtn" href="${pageContext.request.contextPath}/GetUpdateMem?memNo=<%= member.getMemNo() %>" >編輯</a><p class="empty"></p>
			<a class="abtn" href="${pageContext.request.contextPath}/GetAllMems">所有會員資料</a>
			<%-- <a class="abtn" href="${pageContext.request.contextPath}/four/memberAdm/jsp/mgMem.jsp" >回查詢首頁</a><br> --%>
			
		</div>	
	</main>
	
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/four/memberAdm/js/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>
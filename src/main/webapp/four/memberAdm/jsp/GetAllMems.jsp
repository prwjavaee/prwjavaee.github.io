<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.four.memberAdm.bean.MemberBean" %>
<%! @SuppressWarnings("unchecked") %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	    crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/memberAdm/styles/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
	<title>會員資料</title>
	<style>
		.main-block{
			padding-top: 80px;
		}
	</style>

</head>
<body style="background-color:#fdf5e6">

<%@ include file="NavSide.jsp" %>
	<main  class="main-block">
		<div align="center">
			<h2>會員資料</h2>
			<a class="abtn insBtn" href="four/memberAdm/jsp/insert.jsp" >
				<i class="fa-solid fa-user-plus"></i>  新增會員</a>
			<table id="memberTable">
				<thead style="background-color:#CAF4FF">
					<tr>
					<th>會員編號<th>姓名<th>Email<th>性別<th>年齡<th>電話<th>註冊日期<th>狀態<th>編輯<th>封鎖
					</th>
					</tr>
				</thead>
				<tbody>
					<% List<MemberBean> members = (ArrayList<MemberBean>)request.getAttribute("members"); %>
					<% for(MemberBean member : members) { %>
						<tr><td><%= member.getMemNo() %>
						<td><a href="GetMem?memNo=<%= member.getMemNo() %>" ><%= member.getMemName() %></a>	
						<td><%= member.getMemEmail() %>	
						<td>
							<% if(member.getGender() == 0) %> 男
							<% if(member.getGender() == 1) %> 女
			            </td>
						<td><%= member.getAge() %>
						<td><%= member.getPhone() %>
						<td><%= member.getRegDate() %>
						<td><% if(member.getStatus() == 0) %>未驗證
							<% if(member.getStatus() == 1) %>正常
							<% if(member.getStatus() == 2) %>封鎖
						</td>
						<td><a class="updBtn" href="GetUpdateMem?memNo=<%= member.getMemNo() %>" ><i class="fa-solid fa-pen-to-square"></i></a>
						<td><a class="delBtn" href="BlockMem?memNo=<%= member.getMemNo() %>" ><i class="fa-solid fa-ban"></i></a>
					<% } %>
				</tbody>
			</table>
			<h3>共<%= members.size() %>筆會員資料</h3><p>
			<!-- <a class="abtn" href="four/memberAdm/jsp/insert.jsp" >新增</a> -->
			<!-- <a class="abtn" href="four/memberAdm/jsp/mgMem.jsp" >回查詢首頁</a><br> -->
		</div>
	</main>	
	
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/jquery-3.7.1.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js" language="javascript"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	
	
</body>
</html>
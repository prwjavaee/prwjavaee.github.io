<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.coach.bean.CoachBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>教練資料</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/coach/css/CoachPage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="coachpage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="coachTableContainer">
			<h2>教練資料</h2>
			<div class="btnLike">
			    <a href="${pageContext.request.contextPath}/CoachGetAll" class="link-btn1">查詢全部</a>
			    <a href="${pageContext.request.contextPath}/CourseGetAll" class="link-btn2">查詢課程</a>
			</div>
			<div class="coachFunction">
		    	<a href="${pageContext.request.contextPath}/four/coach/jsp/CoachInsert.jsp" id="newcoachbtn">新增教練</a>
	    		<form method="post" action="${pageContext.request.contextPath}/CoachGetByLike">
	            	<input type="text" placeholder="輸入關鍵字" name="likeword"/>
	            	<input type="submit" value="查詢"/>
	    		</form>
			</div>
			<table class="coachTable">
				<tr><th>教練編號<th>教練姓名<th>教練職稱<th>修改<th>刪除</tr>
	    			<c:forEach var="coach" items="${coachs}">
				        <tr>
				            <td>${coach.coachId}</td>
				            <td><a href="${pageContext.request.contextPath}/CoachGetById?coachId=${coach.coachId}">${coach.coachName}</a></td>
				            <td>${coach.coachJob}</td>
				            <td><a href="${pageContext.request.contextPath}/CoachUpdate?coachId=${coach.coachId}">修改</a></td>
				            <td><a href="${pageContext.request.contextPath}/CoachDelete?coachId=${coach.coachId}">刪除</a></td>
				        </tr>
	    			</c:forEach>
			</table>
			<div id="pgbtn"></div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
	<script>
		$(document).ready(function() {
		    var rowsPerPage = 10;
		    var rows = $('.coachTable tr').not(':first-child');
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
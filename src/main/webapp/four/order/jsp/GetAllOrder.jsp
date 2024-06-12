<%@page import="java.util.ArrayList"%>
<%@page import="com.four.order.bean.OrderBean"%>rBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>訂單資料</title>
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body style="background-color: #fdf5e6;">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div align="center" class="main-block">
		<h2>訂單資料</h2>
		<table border="1">
			<tr style="background-color: #a8fefa">
				<th>訂單編號
				<th>會員編號
				<th>總金額
				<th>訂單狀況
				 <%
				List<OrderBean> orders = (ArrayList<OrderBean>) request.getAttribute("orders");
				for (OrderBean order : orders) {
				%>
					<tr>
						<td><%=order.getOrderID()%>
						<td><%=order.getMemberID()%>
						<td><%=order.getTotal()%>
						<td><%=order.getOrderStatus()%>
					</tr>
				 <%
				 }
				 %>
		</table>
		<h3>共<%=orders.size()%>筆</h3>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>

</html>
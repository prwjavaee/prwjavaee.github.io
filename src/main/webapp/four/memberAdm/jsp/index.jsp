<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.four.memberAdm.bean.MemberBean" %>
<%! @SuppressWarnings("unchecked") %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/memberAdm/styles/style.css">
<title>Home Page</title>
</head>
<body style="background-color:#fdf5e6">
	<div align="center">
		<h2>Welcome to the Home Page</h2>
	    <a class="abtn" href="login.jsp">Login</a>
	    <!-- <a href="register.jsp">Register</a> -->
	</div>	
	
	<script src="four/memberAdm/js/jquery-3.7.1.js" language="javascript"></script>
	<script src="four/memberAdm/js/app.js" language="javascript"></script>
</body>
</html>
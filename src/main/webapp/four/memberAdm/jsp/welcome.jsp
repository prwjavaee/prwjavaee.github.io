<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.four.memberAdm.bean.MemberBean" %>
<%! @SuppressWarnings("unchecked") %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ include file="NavSide.jsp" %> --%>
<c:set var="memberNo" value="${user.memNo}" scope="session"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome ! </title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/products/css/mall/HeaderAndFooter.css">
    <style>
    	.container{
    		margin: 110px auto 0 auto;
    	}
    
    	.message {
            font-size: 36px;
            text-align: center;
        }

        .message h1 {
            color: #bdbdbd;
        }

        .message h1 span {
            color: #228fe7;
        }

        .mall {
            margin-top: 25px;
            padding: 10px 20px;
            font-size: 24px;
            border-radius: 15px;
            border: none;
            cursor: pointer;
            background-color: #fff;
        }

        .mall:hover {
            transition: background-color 0.5s ease-in-out;
            background-color: #f3c449;
        }

        .mall:active a {
            background-color: #eecc78;
        }
    </style>
</head>
<body>
	<%@ include file="../../products/jsp/mall/HeaderOutsideMall.jsp" %>
	<article class="container">
        <div class="message">
            <h1 class="zh">登入成功<br>
                <span>
                    ${user.memName}
                </span><br>
                Welcome Back
            </h1>
            <a href="${pageContext.request.contextPath}/ExploreProduct">
                <button class="mall zh">前往商城</button>
            </a>
        </div>
    </article>
	<%@ include file="../../products/jsp/mall/Footer.jsp" %>
</body>
</html>
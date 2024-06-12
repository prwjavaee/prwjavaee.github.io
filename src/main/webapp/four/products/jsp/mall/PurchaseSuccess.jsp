<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gymnity - 感謝您的購買</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${directory}/four/products/css/mall/HeaderAndFooter.css">
    <link rel="stylesheet" href="${directory}/four/products/css/mall/PurchaseSuccess.css">
</head>
<body>
    <%@ include file="Header.jsp" %>
    <div class="container">
        <div class="message">
            <h1 class="title zh">感謝您的購買!!</h1>
            <p class="zh">您的訂單編號 : ${orderID}</p>
            <a href="${directory}/ExploreProduct" class="backToMenu">
                <button class="zh">回到商品列表</button>
            </a>
        </div>
    </div>
    <%@ include file="Footer.jsp" %>
</body>
</html>

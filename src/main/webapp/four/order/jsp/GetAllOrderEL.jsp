<%@page import="java.util.ArrayList"%>
<%@page import="com.four.order.bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>訂單資料</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
    <style>
        body {
            background-color: #fdf5e6;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        .main-block {
            background-color: #fff;
        }
        
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        
        a {
            color: #007BFF;
            text-decoration: none;
            transition: color 0.3s;
        }
        
        a:hover {
            color: #0056b3;
        }
        
        form {
            margin-bottom: 20px;
        }
        
        input[type="search"] {
            padding: 10px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
    </style>
</head>
<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div align="center" class="main-block">
        <h2>訂單資料</h2>
        <form action="${pageContext.request.contextPath}/GetSomeOrder" method="post">
            <input type="search" id="search" name="search" />
            <input type="submit" value="訂單查詢">
        </form>
        <table>
            <tr>
                <th>訂單編號</th>
                <th>會員編號</th>
                <th>總金額</th>
                <th>訂單狀況</th>
                <th>操作</th>
                <th>詳細資料</th>
            </tr>
            <c:forEach items="${orders}" var="order" varStatus="s">
            <tr id="${order.orderID}" name="${order.orderID}">
                <td>${order.orderID}</td>
                <td>${order.memberID}</td>
                <td>${order.total}</td>
                <td>${order.orderStatus}</td>
                <td>
                    <a href="EditOrder?orderID=${order.orderID}"><i class="fa-solid fa-marker fa-xl" style="color: #4798d7;"></i></a>
                </td>
                <td>
                    <a href="SelectAllOrderDetail?orderID=${order.orderID}"><i class="fa-solid fa-receipt fa-xl" style="color: #eac84d;"></i></a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <h3>共${orders.size()}筆</h3>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>

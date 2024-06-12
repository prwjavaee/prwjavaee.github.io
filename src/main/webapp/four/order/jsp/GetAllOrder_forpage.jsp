<%@page import="java.util.ArrayList"%>
<%@page import="com.four.order.bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>訂單資料</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
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
        form {
            margin-bottom: 20px;
        }
        input[type="search"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 200px;
            margin-right: 10px;
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
        .pagination {
            list-style-type: none;
            display: flex;
            justify-content: center;
            padding: 0;
        }
        .pagination li {
            margin: 0 5px;
        }
        .pagination li a {
            display: block;
            padding: 8px 16px;
            text-decoration: none;
            color: #333;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }
        .pagination li a:hover, .pagination .active a {
            background-color: #4CAF50;
            color: #fff;
            border: 1px solid #4CAF50;
        }
    </style>
</head>
<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div class="main-block" align="center">
        <h2>訂單資料</h2>
        <form action="${pageContext.request.contextPath}/GetSomeOrder" method="post">
            <input type="search" id="search" name="search" placeholder="搜尋訂單">
            <input type="submit" value="訂單查詢">
        </form>
        <table>
            <tr>
                <th>訂單編號</th>
                <th>會員編號</th>
                <th>總金額</th>
                <th>訂單狀況</th>
                <th>編輯</th>
                <th>明細</th>
            </tr>
            <c:forEach items="${orders}" var="order" varStatus="s">
                <tr id="${order.orderID}" name="${order.orderID}">
                    <td>${order.orderID}</td>
                    <td>${order.memberID}</td>
                    <td>${order.total}</td>
                    <td>${order.orderStatus}</td>
                    <td><a href="EditOrder?orderID=${order.orderID}"><i class="fa-solid fa-marker fa-xl" style="color: #4798d7;"></i></a></td>
                    <td><a href="SelectAllOrderDetail?orderID=${order.orderID}"><i class="fa-solid fa-receipt fa-xl" style="color: #eac84d;"></i></a></td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <ul class="pagination">
                <c:if test="${currentPage > 1}">
                    <li><a href="GetAllOrder_forpage?page=${currentPage - 1}">&laquo; Previous</a></li>
                </c:if>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <li class="${currentPage == i ? 'active' : ''}"><a href="GetAllOrder_forpage?page=${i}">${i}</a></li>
                </c:forEach>
                <c:if test="${currentPage < noOfPages}">
                    <li><a href="GetAllOrder_forpage?page=${currentPage + 1}">Next &raquo;</a></li>
                </c:if>
            </ul>
        </div>
        <h3>共 ${orders.size()} 筆</h3>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>

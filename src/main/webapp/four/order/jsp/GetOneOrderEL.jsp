<%@page import="com.four.order.bean.OrderBean"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>訂單資料修改</title>
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
        .form-container {
            display: flex;
            align-items: center;
        }
        .form-container select {
            margin-right: 10px;
        }
        .form-container button {
            padding: 10px 20px;
            border: none;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div class="main-block" align="center">
        <h2>訂單資料修改</h2>
        <table>
            <tr>
                <th>訂單編號</th>
                <th>會員編號</th>
                <th>總金額</th>
                <th>訂單狀況</th>
            </tr>
            <tr id="${order.orderID}" name="${order.orderID}">
                <td>${order.orderID}</td>
                <td>${order.memberID}</td>
                <td>${order.total}</td>
                <td>
                    <form class="form-container" action="UpdateOrderStatus" method="post">
                        <input type="hidden" name="orderID" value="${order.orderID}">
                        <select name="orderStatus">
                            <option value="Pending" <c:if test="${order.orderStatus == 'Pending'}">selected</c:if>>Pending</option>
                            <option value="Shipped" <c:if test="${order.orderStatus == 'Shipped'}">selected</c:if>>Shipped</option>
                            <option value="Completed" <c:if test="${order.orderStatus == 'Completed'}">selected</c:if>>Completed</option>
                            <option value="Cancel" <c:if test="${order.orderStatus == 'Cancel'}">selected</c:if>>Cancel</option>
                        </select>
                        <button type="submit">確認</button>
                    </form>
                </td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/GetAllOrder_forpage"><i class="fa-solid fa-rotate-left fa-xl" style="color: #2497f0;"></i>Back</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>

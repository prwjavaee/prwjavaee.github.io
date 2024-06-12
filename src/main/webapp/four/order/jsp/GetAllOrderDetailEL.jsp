<%@page import="com.four.order.bean.OrderBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>訂單明細資料</title>
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
        h2, h3 {
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
    </style>
</head>
<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div class="main-block" align="center">
        <h2>訂單明細資料</h2>
        <h3>訂單編號: ${orderDetail[0].orderID}</h3>
        <table>
            <tr>
                <th>商品編號</th>
                <th>商品名稱</th>
                <th>購買日期</th>
                <th>數量</th>
                <th>單價</th>
            </tr>
            <c:forEach var="detail" items="${orderDetail}">
                <tr>
                    <td>${detail.productID}</td>
                    <td>${detail.productName}</td>
                    <td class="time">${detail.orderDate}</td>
                    <td>${detail.quantity}</td>
                    <td>${detail.unitPrice}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/GetAllOrder_forpage"><i class="fa-solid fa-rotate-left fa-xl" style="color: #2497f0;"></i>Back</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/memberAdm/js/app.js"></script>
    <script>
        function formatDateTime() {
            let timeElements = document.querySelectorAll('.time');
            timeElements.forEach(function(element) {
                let date = element.textContent;
                date = date.replace("T", " ");
                date = date.split(".")[0];
                element.textContent = date;
            });
        }
        window.onload = function() {
            formatDateTime();
        };
    </script>
</body>
</html>

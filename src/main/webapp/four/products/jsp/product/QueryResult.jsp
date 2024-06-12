<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理系統 - 查詢商品</title>
    <link rel="stylesheet" href="${directory}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/AllProducts.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/QueryResult.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/Table.css">
    <link rel="stylesheet" href="${directory}/four/BackStageAllCss/BackStageAllPage.css">
</head>

<body>
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="container main-block">
		<h1 class="title">商品列表</h1>
        <div class="searchBar">
            <form method="post" action="${directory}/FuzzySearch" class="search-form">
                <input class="query-input validate" type="text" name="query" id="query" placeholder="請輸入商品名稱或類別名稱">
                <input class="functionBtn" type="submit" value="查詢資料庫" id="search-submit">
            </form>
        </div>
        <div class="buttons">
        	<a href="${directory}/AllProducts">
	                <button class="functionBtn"><i class="fa-solid fa-house"></i> 回商品列表</button>
            </a>
        	<button class="functionBtn delete"><i class="fa-solid fa-trash-can"></i> 刪除資料</button>
            <button class="functionBtn delete-confirmed"><i class="fa-solid fa-trash-can"></i> 確認刪除</button>
        </div>
        <div class="table-container">
	        <form method="post" action="${directory}/DeleteProduct" class="delete-form">
			<table>
	            <thead>
	                <tr>
	                    <td>商品編號</td>
	                    <td>商品類別</td>
	                    <td>商品名稱</td>
	                    <td>價格</td>
	                    <td>庫存</td>
	                    <td>上架日期</td>
	                    <td>修改</td>
                        <td class="delete-column delete-title">刪除</td>
	                </tr>
	            </thead>
	            <tbody>
		            <c:forEach items="${productsFound}" var="product">
		            	<c:set var="productID" value="${product.productID}" />
		                <tr>
		                    <td><a href="${directory}/SingleProductDetail?productID=${product.productID}">${product.productID}</a></td>
		                    <td><a href="${directory}/SingleProductDetail?productID=${product.productID}">${product.categoryName}</a></td>
		                    <td><a href="${directory}/SingleProductDetail?productID=${product.productID}">${product.productName}</a></td>
		                    <td><a href="${directory}/SingleProductDetail?productID=${product.productID}">${product.price}</a></td>
		                    <td><a href="${directory}/SingleProductDetail?productID=${product.productID}">${product.stock}</a></td>
		                    <td><a href="${directory}/SingleProductDetail?productID=${product.productID}">${product.listingDate}</a></td>
		                    <td><a href="${directory}/GetInfoBeforeUpdate?productID=${product.productID}&page=query">
	                                <button class="functionBtn" type="button">修改資料</button>
	                            </a></td>
	                        <td class="delete-column">
	                            <input type="checkbox" name="delete" id="delete-checkbox" value="${product.productID}">
	                        </td>
		                </tr>
		            </c:forEach>
	            </tbody>
	        </table>
            </form>
	        <div class="totalmsg">總共有 ${productsFound.size()} 筆商品資料</div>
        </div>
	</div>

	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="${directory}/four/products/javascript/product/QueryResult.js"></script>
	<script src="${directory}/four/products/javascript/product/ValidateForm.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>

</html>
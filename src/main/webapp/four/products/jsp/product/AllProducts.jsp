<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理系統 - 商品後台列表</title>
    <link rel="stylesheet" href="${directory}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${directory}/four/BackStageAllCss/BackStageAllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/AllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/AllProducts.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/Table.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/Modal.css">
</head>

<body>
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="container main-block">
		<h1 class="title">商品列表</h1>
        <div class="buttons">
        	<a href="${directory}/SearchAllCategory?action=insert">
            	<button class="functionBtn add"><i class="fa-solid fa-circle-plus"></i> 新增商品</button>	        	
        	</a>
        	<a href="${directory}/four/products/jsp/product/QueryResult.jsp">
	            <button class="functionBtn query"><i class="fa-solid fa-magnifying-glass"></i> 查詢商品資料</button>
            </a>
            <button class="functionBtn delete"><i class="fa-solid fa-trash-can"></i> 刪除資料</button>
            <button class="functionBtn delete-confirmed" disabled><i class="fa-solid fa-trash-can"></i> 確認刪除</button>
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
	                    <td>修改資料</td>
                        <td class="delete-column delete-title">刪除</td>
	                </tr>
	            </thead>
	            <tbody>
		            <c:forEach items="${allProducts}" var="product">
		            	<c:set var="productID" value="${product.productID}" />
		                <tr>
		                    <td><a class="link" href="${directory}/SingleProductDetail?productID=${product.productID}">${product.productID}</a></td>
		                    <td><a class="link" href="${directory}/SingleProductDetail?productID=${product.productID}">${product.categoryName}</a></td>
		                    <td><a class="link" href="${directory}/SingleProductDetail?productID=${product.productID}">${product.productName}</a></td>
		                    <td><a class="link" href="${directory}/SingleProductDetail?productID=${product.productID}">${product.price}</a></td>
		                    <td><a class="link" href="${directory}/SingleProductDetail?productID=${product.productID}">${product.stock}</a></td>
		                    <td><a class="link" href="${directory}/SingleProductDetail?productID=${product.productID}">${product.listingDate}</a></td>
		                    <td><a class="link" href="${directory}/GetInfoBeforeUpdate?productID=${product.productID}">
	                                <button class="functionBtn" type="button"><i class="fa-solid fa-wrench"></i></button>
	                            </a></td>
	                        <td class="delete-column">
	                            <input type="checkbox" name="delete" id="delete-checkbox" value="${product.productID}">
	                        </td>
		                </tr>
		            </c:forEach>
	            </tbody>
	        </table>
            </form>
	        <div class="totalmsg">總共有 ${allProducts.size()} 筆商品資料</div>
	        <div class="model delete-success">
                <div class="model-content">
                    <h1>商品刪除成功！</h1>
                    <button class="confirmed">確定</button>
                </div>
            </div>
        </div>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="${directory}/four/products/javascript/product/AllProducts.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
	<script>
		$(function(){
			const deleteStatus = ${status};
			if(deleteStatus){
				$('.model').css('display', 'block');
			}
			$('.confirmed').on('click', function () {
                $('.model').css('display', 'none');
            })
		})
	</script>
</body>

</html>
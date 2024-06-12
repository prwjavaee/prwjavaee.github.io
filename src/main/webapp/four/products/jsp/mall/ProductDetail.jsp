<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gymnity - ${sessionScope.selectedProduct.productName}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${directory}/four/products/css/mall/HeaderAndFooter.css">
    <link rel="stylesheet" href="${directory}/four/products/css/mall/Detail.css">
    <link rel="stylesheet" href="${directory}/four/products/css/mall/QuantitySet.css">
</head>

<body>
    <%@ include file="Header.jsp" %>
    <div class="explore-page">
        <a href="${directory}/ExploreProduct">
            <i class="fa-solid fa-house"></i>
        </a>
    </div>
    <article class="container">
        <form class="productForm" method="post" action="${directory}/Purchase">
        <div>
            <img src="data:image/jpeg;base64,${productImage[2]}" alt="商品圖片" class="productImg">
        </div>
        <div class="description">
            <h2 class="zh productCategory">${sessionScope.selectedProduct.categoryName}</h2>
            <h1 class="productName zh">${sessionScope.selectedProduct.productName}</h1>
            <p class="price zh">價格 : ${sessionScope.selectedProduct.price}</p>
            <div class="quantitySet">
                <button class="func-btn quantity minus">-</button>
                <input type="text" name="quantity" class="number" value="0">
                <button class="func-btn quantity add">+</button>
            </div>
            <div class="btns">
                <button type="button" id="purchase" class="func-btn zh">直接購買</button>
                <button type="button" id="cart" class="func-btn zh">加入購物車</button>
            </div>
        </div>
        </form>
        <div class="model">
            <div class="model-content">
                <h1 class="zh model-title">加入購物車成功！</h1>
                <button class="func-btn zh confirmed" id="submit">確定</button>
            </div>
        </div>
    </article>
    <%@ include file="Footer.jsp" %>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="${directory}/four/products/javascript/mall/QuantitySet.js"></script>
	<script src="${directory}/four/products/javascript/mall/ProductDetail.js"></script>
	<script>
		$(function () {
	        const inTheCart = ${inTheCart};
	
	        if (inTheCart) {
	            $('.model').css('display', 'block');
	        }
	
	        $('.confirmed').on('click', function () {
	            $('.model').css('display', 'none');
	        })
	    })
	</script>
</body>
</html>
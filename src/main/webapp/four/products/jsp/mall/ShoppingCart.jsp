<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gymnity - 購物車</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${directory}/four/products/css/mall/HeaderAndFooter.css">
    <link rel="stylesheet" href="${directory}/four/products/css/mall/ShoppingCart.css">
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
	<div class="product-cart">
		<c:choose>
			<c:when test="${not empty sessionScope.cart}">
				<c:forEach items="${sessionScope.cart}" var="product">
					<div class="product">
						<div>
							<img src="data:image/jpeg;base64,${product[2][2]}" alt="商品圖片" class="productImg">
						</div>
						<div class="description">
							<input type="hidden" class="productID" value="${product[1].productID}">
							<h4 class="zh productCategory">${product[1].categoryName}</h4>
							<h1 class="productName zh">${product[1].productName}</h1>
							<p class="hiddenPrice" style="display: none;">${product[1].price}</p>
							<p class="price zh">$${product[1].price * product[3]}</p>
							<div class="quantitySet">
								<button class="func-btn quantity minus">-</button>
								<input type="text" name="quantity" class="number" value="${product[3]}">
								<button class="func-btn quantity add">+</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="message zh">購物車是空的喔！</div>	     
			</c:otherwise>
		</c:choose>
	</div>
	<aside>
		<form method="post" action="${directory}/CartUpdate">
			<p class="totalCN zh">總金額：</p>
			<p class="total zh">$</p>
			<input type="hidden" name="orderData" id="orderData">
			<button class="func-btn orderSubmit zh">訂單送出</button>
		</form>
	</aside>
	<aside class="empty">
		<form method="post" action="${directory}/EmptyCart">
			<button class="func-btn emptybtn zh">清空購物車</button>
		</form>
	</aside>
	</article>
    <%@ include file="Footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/products/javascript/mall/ShoppingCart.js"></script>
</body>
</html>
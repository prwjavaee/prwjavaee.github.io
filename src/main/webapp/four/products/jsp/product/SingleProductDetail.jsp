<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理系統 - 商品資訊 - ${selectedProduct.productName}</title>
    <link rel="stylesheet" href="${directory}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${directory}/four/BackStageAllCss/BackStageAllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/AllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/SingleProductDetail.css">
</head>

<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div class="container main-block">
        <h1 class="detail-title">商品資訊</h1>
        <div class="detail-container">
            <div class="photo">
                <figure>
                    <img class="product-image" src="data:image/jpeg;base64,${imageData}" alt="">
                </figure>
            </div>
            <div class="product-info">
                <table>
                    <tr>
                        <td class="label-td">商品編號：</td>
                        <td class="data-td"><span id="productID">${selectedProduct.productID}</span></td>
                    </tr>
                    <tr>
                        <td class="label-td">商品類別：</td>
                        <td class="data-td"><span id="category">${selectedProduct.categoryName}</span></td>
                    </tr>
                    <tr>
                        <td class="label-td">商品名稱：</td>
                        <td class="data-td"><span id="productName">${selectedProduct.productName}</span></td>
                    </tr>
                    <tr>
                        <td class="label-td">價格：</td>
                        <td class="data-td"><span id="price">${selectedProduct.price}</span></td>
                    </tr>
                    <tr>
                        <td class="label-td">上架日期：</td>
                        <td class="data-td"><span id="listingDate">${selectedProduct.listingDate}</span></td>
                    </tr>
                    <tr>
                        <td class="label-td">庫存量：</td>
                        <td class="data-td"><span id="quantity">${selectedProduct.stock}</span></td>
                    </tr>
                    <tr>
                        <td class="label-td">商品特色：</td>
                        <td class="data-td"><span id="feature">${selectedProduct.productFeatures}</span></td>
                    </tr>
                </table>
            </div>
        </div>
        <a href="${directory}/AllProducts">
        	<button class="functionBtn main-menu"><i class="fa-solid fa-house"></i> 回商品列表</button>
    	</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/memberAdm/js/app.js"></script>
</body>

</html>
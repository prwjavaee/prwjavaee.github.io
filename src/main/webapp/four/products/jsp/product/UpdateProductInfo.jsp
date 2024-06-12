<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理系統 - 更新商品資訊 - ${selectedProduct.productName}</title>
    <link rel="stylesheet" href="${directory}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${directory}/four/BackStageAllCss/BackStageAllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/AllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/Modal.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/UpdateProductInfo.css">
</head>

<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div class="container main-block">
        <h1 class="update-title">更新商品資訊</h1>
        <div class="inside">
            <div class="photo">
                <a href="${directory}/AllProducts" class="backBtn">
                    <button class="functionBtn main-menu"><i class="fa-solid fa-house"></i> 回商品列表</button>
                </a>
                <figure>
                    <img class="product-image" src="data:image/jpeg;base64,${productImage}" alt="">
                </figure>
            </div>
            <div class="product-info">
                <form method="post" action="${directory}/UpdateProductInfo" class="update-form">
                    <div class="info-block">
                        <label for="productID"><span>*</span>商品編號：</label>
                        <input type="text" value="${selectedProduct.productID}" class="update-input validate" readonly>
                        <input type="hidden" name="productID" value="${selectedProduct.productID}">
                    </div>
                    <div class="info-block">
                        <label for="category"><span>*</span>商品類別：</label>
                        <select class="update-input validate" name="categoryName" id="productCategory">
                            <c:forEach items="${allCategories}" var="category">
 	                       		<option value="${category.categoryName}"
                               	<c:if test="${selectedProduct.categoryName eq category.categoryName}">
                                   selected
                               	</c:if>
                           	>${category.categoryName}</option>
                    		</c:forEach>
                        </select>
                    </div>
                    <div class="info-block">
                        <label for="productName"><span>*</span>商品名稱：</label>
                        <input type="text" name="productName" class="update-input validate" value="${selectedProduct.productName}">
                    </div>
                    <div class="info-block">
                        <label for="price"><span>*</span>價格：</label>
                        <input type="number" class="update-input validate" name="price" value="${selectedProduct.price}">
                    </div>
                    <div class="info-block">
                        <label for="stock"><span>*</span>庫存量：</label>
                        <input type="number" class="update-input validate" name="stock" value="${selectedProduct.stock}">
                    </div>
                    <div class="info-block">
                        <label for="listingDate"><span>*</span>上架日期：</label>
                        <input type="date" class="update-input validate" name="listingDate" value="${selectedProduct.listingDate}">
                    </div>
                    <div class="info-block">
                        <label for="feature">商品特色：</label>
                        <textarea class="update-input" name="feature" id="feature">${selectedProduct.productFeatures}</textarea>
                    </div>
                    <button class="functionBtn update-submit">送出資料</button>
                </form>
                <div class="model update-confirm">
                    <div class="model-content">
                        <h1>確定要更新商品嗎?</h1>
                        <button class="cancel">取消</button>
                        <button class="confirmed" id="submit">確定</button>
                    </div>
                </div>
            </div>
            <div class="model update-success">
                <div class="model-content">
                    <h1>商品更新成功！</h1>
                    <button class="functionBtn confirmed">確定</button>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/products/javascript/product/ValidateForm.js"></script>
        <script src="${directory}/four/memberAdm/js/app.js"></script>
    <script>
    	$(function () {
    		
    		
    	    $('.update-submit').on('click', function (event) {
    	    	event.preventDefault();
    	        $('.update-confirm').css('display', 'block');
    	    });
    	    $('#submit').on('click', function () {
    	        $('.update-form').submit();
    	    });
    	    
    	    let updateStatus = ${status} != null ? ${status} : null;
    	    if (updateStatus) {
    	        $('.update-success').css('display', 'block');
    	    }
    	    
    	    $('.confirmed').on('click', function(){
    	        $('.update-success').css('display', 'none');
    	    });


    	    $('.cancel').on('click', function (event) {
    	        event.preventDefault();
    	        $('.update-confirm').css('display', 'none');
    	    });

    	    $(window).on('click', function (event) {
    	        if (event.target === $('.update-confirm')[0] || event.target === $('.update-success')[0]) {
    	            $('.model').css('display', 'none');
    	        }
    	    });
    	});
    </script>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理系統 - 新增商品</title>
    <link rel="stylesheet" href="${directory}/four/memberAdm/styles/nav_side_style.css">
    <link rel="stylesheet" href="${directory}/four/BackStageAllCss/BackStageAllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/AllPage.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/InsertProduct.css">
    <link rel="stylesheet" href="${directory}/four/products/css/product/Modal.css">
</head>

<body>
    <%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
    <div class="container main-block">
        <div class="model category-model">
            <div class="model-content">
                <h2>新增類別</h2>
                <form method="post" action="${directory}/NewCategory" class="category-form">
                    <div class="category-input">
                        <label for="category"><span>*</span>商品類別 : </label>
                        <input type="text" name="category" class="input" id="category">
                    </div>
                    <button class="cancel">取消</button>
                    <button class="category-confirmed">確定</button>
                </form>
            </div>
        </div>
        <h1 class="title">商品列表</h1>
        <div class="form-container">
            <form method="post" action="${directory}/InsertProduct" class="main-form"  enctype="multipart/form-data">
                <div class="inputdiv">
                    <label for="productCategory"><span>*</span>商品類別 : </label>
                    <select class="in input validate" name="productCategory">
                        <option value="">----</option>
	                    	<c:forEach items="${allCategories}" var="category">
		                    	<c:choose>
			                    	<c:when test="${categoryAdded eq true}">
			 	                       <option value="${category.categoryName}" selected>${category.categoryName}</option>
			                    	</c:when>
			                    	<c:otherwise>
			 	                       <option value="${category.categoryName}">${category.categoryName}</option>                    		
			                    	</c:otherwise>
		                    	</c:choose>
	                    	</c:forEach>
                    </select>
                    <button class="func addcate">新增類別</button>
                </div>
                <div class="inputdiv">
                    <label for="productName"><span>*</span>商品名稱 : </label>
                    <input class="in input text validate" type="text" name="productName">
                </div>
                <div class="price inputdiv">
                    <label for="price"><span>*</span>價錢 : </label>
                    <input class="in input text validate" type="number" name="price">
                </div>
                <div class="quantity inputdiv">
                    <label for="quantity"><span>*</span>數量 : </label>
                    <input class="in input text validate" type="number" name="quantity">
                </div>
                <input type="hidden" name="listingDate">
                <div class="featurediv inputdiv">
                    <label class="featurelabel" for="feature">商品特色 : </label>
                    <textarea class="in text" name="feature"></textarea>
                </div>
                <div class="inputdiv">
                    <label for="image"><span>*</span>商品圖片 : </label>
                    <input type="file" class="validate imginput" name="image" style="display: none;">
                    <button type="button" class="func upload">上傳圖片</button>
                    <span class="uploadSpan">未選擇檔案</span>
                </div>
                <div class="buttons inputdiv">
                    <input class="func reset" type="reset" value="清除資料">
                    <input class="func insert" type="submit" value="新增商品"></input>
                </div>
                <div class="model add-confirmed">
                    <div class="model-content">
                        <p>確認新增商品嗎?</p>
                        <button class="cancel">取消</button>
                        <input type="submit" class="confirmed" value="確定">
                    </div>
                </div>
            </form>
            <div class="model insert-success">
                <div class="model-content">
                    <h1>商品新增成功！</h1>
                    <button class="message-confirmed">確定</button>
                </div>
            </div>
        </div>
        <a href="${directory}/AllProducts">
            <button class="func main-menu"><i class="fa-solid fa-house"></i> 回商品列表</button>
        </a>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="${directory}/four/memberAdm/js/app.js"></script>
    <script>
	    $(function () {
	        let insertStatus = ${ status };
	        if (insertStatus) {
	            $('.insert-success').css('display', 'block');
	        }
	        $('.message-confirmed').on('click', function (event) {
	            event.preventDefault();
	            $('.insert-success').css('display', 'none');
	        });

	        $('.insert').on('click', function (event) {
	            event.preventDefault();
	            $('.add-confirmed').css('display', 'block');
	        });

	        $('.upload').click(function () {
	            $('.imginput').click();
	        });

	        $('.imginput').on('change', function () {
	            const filenames = [];
	            for (let i = 0; i < this.files.length; i++) {
	                let filename = this.files[i].name;
	                filenames.push(filename);
	            }
	            $('.uploadSpan').text(`已選擇1個檔案`);
	        });

	        $('.confirmed').on('click', function (event) {
	            if (validateForm()) {
	                $('.main-form').submit();
	            } else {
	                alert('請填寫所有必填項！');
	                $('.model').css('display', 'none');
	                event.preventDefault();
	            }
	        });

	        //modal
	        const categorymodal = $('.category-model');
	        const addmodal = $('.add-confirmed');
	        const modelButton = $('.insert');
	        const addCategory = $('.addcate');

	        modelButton.on('click', function (event) {
	            event.preventDefault();
	            $('.add-confirmed').css('display', 'block');
	        });

	        $('.cancel').on('click', function (event) {
	            event.preventDefault();
	            $('.model').css('display', 'none');
	        });

	        $(window).on('click', function (event) {
	            if (event.target == addmodal[0] || event.target == categorymodal[0]) {
	                $('.model').css('display', 'none');
	            }
	        });

	        addCategory.on('click', function () {
	            categorymodal.css('display', 'block');
	            return false;
	        });

	        function validateForm() {
	            let isValid = true;
	            $('.validate').each(function () {
	                if ($(this).val().trim() === '') {
	                    isValid = false;
	                    return false;
	                }
	            });
	            return isValid;
	        }
	    })
    </script>
</body>

</html>
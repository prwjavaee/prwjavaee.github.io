<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gymnity - 商品列表</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${directory}/four/products/css/mall/HeaderAndFooter.css">
    <link rel="stylesheet" href="${directory}/four/products/css/mall/Mall.css">
</head>

<body>
	<%@ include file="Header.jsp" %>
	<article>
        <h1 class="page-title zh">商品列表</h1>
        <hr>
        <div class="container explore-box">
            <table>
                <c:forEach items="${allProducts}" var="product" varStatus="loop">
			    <c:if test="${loop.index % 3 == 0}">
                <tr>
                </c:if>
                    <td>
                        <c:set var="productID" value="${product.productID}" />
                        <a href="${directory}/ProductDetail?productID=${productID}">
                        <div class="product">
	                            <div class="psquare">
	                                <c:forEach items="${allImages}" var="img">
	                                    <c:if test="${img[1] eq productID and img[0] eq 1}">
	                                        <img src="data:image/jpeg;base64,${img[2]}" alt="" class="productImg">
	                                    </c:if>
	                                </c:forEach>
	                            </div>
                            <div class="content">
                                <h3 class="description zh" id="category">${product.categoryName}</h3>
                                <h1 class="description zh" id="name">${product.productName}</h1>
                            </div>
                        </div>
                      	</a>
                    </td>
                <c:if test="${loop.index % 3 == 2 or loop.last}">
                </tr>
                </c:if>
                </c:forEach>
            </table>
        </div>
        <hr>
    </article>
	<%@ include file="Footer.jsp" %>
</body>

</html>
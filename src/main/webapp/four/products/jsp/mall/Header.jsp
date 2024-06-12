<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
    <a href="${pageContext.request.contextPath}/ExploreProduct" class="headTitle title-en">GYMNITY</a>
    <input type="hidden" name="memberNo" value="${memberNo}">
    <ul class="menu">
        <li>
            <i class="fa-solid fa-user fa-2x"></i>
            <ul class="drop-menu">
                <li class="option">
                    <a href="${pageContext.request.contextPath}/LogoutAdm" class="zh logout">登出</a>
                </li>
            </ul>
        </li>
    </ul>
    <a href="${pageContext.request.contextPath}/four/products/jsp/mall/ShoppingCart.jsp" class="cart">
    	<i class="fa-solid fa-cart-shopping fa-lg"></i>
    </a>
</header>

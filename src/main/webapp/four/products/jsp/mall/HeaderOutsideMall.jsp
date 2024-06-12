<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
     <h1 class="headTitle en">GYMNITY</h1>
     <input type="hidden" name="memberNo" value="${memberNo}">
     <ul class="menu">
         <li>
             <i class="fa-solid fa-user fa-2x"></i>
             <ul class="drop-menu">
                 <li class="option">
                     <a href="${pageContext.request.contextPath}/LogoutAdm" class="zh">登出</a>
                 </li>
             </ul>
         </li>
     </ul>
 </header>
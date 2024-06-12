<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
 <header>
     <section class="logo">
     	<a href="${pageContext.request.contextPath}/four/memberAdm/jsp/mgMem.jsp">
     		<img src="${directory}/four/memberAdm/images/Logo-without-name.png"></a>
         <h1>GYMNITY管理系統</h1>
     </section>
     <nav>
         <ul>
             <li><a><img src="${pageContext.request.contextPath}/four/memberAdm/images/test-account.png" alt=""></a>
                 <!-- <i class="fa-solid fa-circle-user"></i> -->
                 <ul class="dropdown-admin">
                     <li><a href="${pageContext.request.contextPath}/four/memberAdm/jsp/mgMem.jsp">後台首頁</a>
                     </li>
                     <li><a href="${pageContext.request.contextPath}/LogoutAdm">登出</a>
                     </li>
                 </ul>
             </li>
         </ul>
     </nav>
 </header>

 <!-- 側邊欄 -->
 <div id="sidebar">
     <div class="sidebar-header">
         <!-- <h3>Sidebar Menu</h3> -->
     </div>
     <ul class="list-unstyled">
         <li class="sideMenu">
             <a href="#item1Submenu" class="dropdown-toggle sidebar-link">
                 <i class="fa-solid fa-user"></i> 會員</a>
             <ul class="list-unstyled submenu" id="item1Submenu">
                 <li>
                     <a href="${pageContext.request.contextPath}/GetAllMems" class="sidebar-link">會員管理</a>
                 </li>
             </ul>
         </li>
         <li class="sideMenu">
             <a href="#item2Submenu" class="dropdown-toggle sidebar-link">
                 <i class="fa-regular fa-calendar-check"></i> 課程</a>
             <ul class="list-unstyled submenu" id="item2Submenu">
                 <li>
                     <a href="${directory}/CoachGetAll" class="sidebar-link">教練管理</a>
                 </li>
                 <li>
                     <a href="${directory}/CourseGetAll" class="sidebar-link">課程管理</a>
                 </li>
                 <li>
                     <a href="${directory}/ScheduleShowAll" class="sidebar-link">課表管理</a>
                 </li>
             </ul>
         </li>
         <li class="sideMenu">
             <a href="#item3Submenu" class="dropdown-toggle sidebar-link">
                 <i class="fa-solid fa-shop"></i> 商城</a>
             <ul class="list-unstyled submenu" id="item3Submenu">
                 <li>
                     <a href="${directory}/AllProducts" class="sidebar-link">商品管理</a>
                 </li>
                 <li>
                     <a href="${directory}/GetAllOrder_forpage" class="sidebar-link">訂單管理</a>
                 </li>
             </ul>
         </li>
         <li class="sideMenu">
             <a href="#item3Submenu" class="dropdown-toggle sidebar-link">
                 <i class="fa-solid fa-bowl-food"></i> 菜單</a>
             <ul class="list-unstyled submenu" id="item3Submenu">
                 <li>
                     <a href="${directory}/ShowFood" class="sidebar-link">菜單管理</a>
                 </li>
                 
             </ul>
         </li>
         <li class="sideMenu">
             <a href="#item3Submenu" class="dropdown-toggle sidebar-link">
                 <i class="fa-solid fa-newspaper"></i> 文章</a>
             <ul class="list-unstyled submenu" id="item3Submenu">
                 <li>
                     <a href="${directory}/GetAllArticles" class="sidebar-link">文章管理</a>
                 </li>
                 
             </ul>
         </li>
     </ul>
 </div>

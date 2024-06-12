<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="directory" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gymnity - 首頁</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${directory}/four/products/css/mall/FrontHomePage.css">
	<style>
		body {
		  overflow: hidden;
		}
		body section.animationWrapper {
		  position: fixed;
		  width: 101%;
		  height: 100%;
		  background-color: white;
		  left: -5px;
		  top: -5px;
		}
		body section.animationWrapper section.animation {
		  margin-top: 10vh;
		  height: 80vh;
		  display: flex;
		  justify-content: center;
		  align-items: center;
		}
		body section.animationWrapper section.animation .hero {
		  width: 100%;
		  height: 0;
		}
		body section.animationWrapper section.animation .hero img {
		  width: 100%;
		  height: 100%;
		  -o-object-fit: cover;
		     object-fit: cover;
		}
		body section.animationWrapper .slider {
		  position: absolute;
		  top: 0;
		  left: 0;
		  width: 100%;
		  height: 100vh;
		  background: linear-gradient(to right, rgb(144, 144, 144), black);
		  z-index: -1;
		}
		.content {
		  display: none; /* 初始隐藏页面内容 */
		}
		body.loaded .content {
		  display: block; /* 动画结束后显示页面内容 */
		}
		body.loaded .animationWrapper {
		  display: none; /* 动画结束后隐藏动画 */
		}
		
		.logo{
			width: 135px;
			height:135px;
		}
    </style>
</head>

<body>
	<!-- 開場動畫 -->
    <section class="animationWrapper">
        <section class="animation">
            <div class="hero">
                <img src="../../css/mall/gym-background.jpg" alt="math img">
            </div>
        </section>
        <div class="slider"></div>
    </section>

	<div class="content">
    <header class="forHeader">
        <img src="${directory}/four/products/image/Logo.png" class="logo">
    </header>
    <article class="container">
        <div class="shadow"></div>
        <div class="message">
            <h1 class="en">WELCOME TO GYMNITY</h1>
            <a href="${directory}/four/memberAdm/jsp/login.jsp">
                <button class="login en">Login / Register</button>
            </a>
        </div>
        <div class="another-shadow"></div>
    </article>
    <footer class="forFooter">
        <ul class="icons">
            <li class="item">
                <a href="">
                    <i class="fa-brands fa-instagram"></i>
                </a>
            </li>
            <li class="item">
                <a href="">
                    <i class="fa-brands fa-facebook"></i>
                </a>
            </li>
            <li class="item">
                <a href="">
                    <i class="fa-brands fa-line"></i>
                </a>
            </li>
            <li class="item">
                <a href="">
                    <i class="fa-brands fa-youtube"></i>
                </a>
            </li>
        </ul>
        <div class="en">COPYRIGHT © XXX. ALL RIGHTS RESERVED.</div>
    </footer>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TimelineMax.min.js" integrity="sha512-0xrMWUXzEAc+VY7k48pWd5YT6ig03p4KARKxs4Bqxb9atrcn2fV41fWs+YXTKb8lD2sbPAmZMjKENiyzM/Gagw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js" integrity="sha512-DkPsH9LzNzZaZjCszwKrooKwgjArJDiEjA5tTgr3YX4E6TYv93ICS8T41yFHJnnSmGpnf0Mvb5NhScYbwvhn2w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
        let hero = document.querySelector(".hero");
        let slider = document.querySelector(".slider");
        let animation = document.querySelector("section.animationWrapper");

        const time_line = new TimelineMax();

        // parameter1 是要控制的對象, 2 是多久
        // 3 是控制對象的原始狀態, 4 動畫結束後的狀態
        // 5 延後或提早開始動畫
        time_line.fromTo(
            hero, 1, { height: "0%" }, 
            { height: "100%", ease: Power2.easeInOut }
        )
        .fromTo(
            hero, 1, { width: "80%" }, 
            { width: "100%", ease: Power2.easeInOut }
        )
        .fromTo(
            slider, 1, { x: "-100%" }, 
            { x: "0%", ease: Power2.easeInOut},
            "-=1"
        )
        .fromTo(
            animation, 0.3, { opacity: 1 }, 
            { opacity: 0 }
        );

        setTimeout( () => {
            animation.style.pointerEvents = "none";
        }, 2400);
        
        document.addEventListener("DOMContentLoaded", function() {
            // 模拟动画播放时间，设定为3秒
            setTimeout(function() {
                // 动画结束后，添加 'loaded' 类到 body
                document.body.classList.add('loaded');
            }, 2300); // 3秒
        });
    </script>
</body>

</html>
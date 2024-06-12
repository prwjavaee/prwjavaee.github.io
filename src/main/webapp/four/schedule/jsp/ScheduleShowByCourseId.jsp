<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.schedule.bean.ScheduleBean, java.lang.SuppressWarnings"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>課表</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/schedule/css/SchedulePage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="schedulepage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="scheduleShowContainer">
			<div class="btnLike">
				<a href="${pageContext.request.contextPath}/CourseGetById?courseId=${courseId}" class="link-btn1">回到課程</a>
				<a href="${pageContext.request.contextPath}/CourseGetAll" class="link-btn2">查詢課程</a>
			</div>
			<h2>課表</h2>
			<table class="scheduleTable">
			  <tr>
			    <th>時間\日期</th>
			    <th>星期一</th>
			    <th>星期二</th>
			    <th>星期三</th>
			    <th>星期四</th>
			    <th>星期五</th>
			    <th>星期六</th>
			    <th>星期日</th>
			  </tr>
			  <% 
			  	@SuppressWarnings("unchecked")
			    ArrayList<ScheduleBean> schedules = (ArrayList<ScheduleBean>)request.getAttribute("schedules");
			
			    String[] daytimes = {"Morning (6:00 AM - 12:00 PM)", "Afternoon (12:00 PM - 6:00 PM)", "Evening (6:00 PM - 10:00 PM)", "Night (10:00 PM - 6:00 AM)"};
			    String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			    for (String daytime : daytimes) {
			        out.println("<tr>");
			        out.println("<td><b>" + daytime + "</b></td>");
			        for (String weekday : weekdays) {
			            String courseName = "";
			            for (ScheduleBean schedule : schedules) {
			                if (schedule.getWeekday().equals(weekday) && schedule.getDaytime().equals(daytime.split(" ")[0])) {
			                    courseName = schedule.getCourseName();
			                    break;
			                }
			            }
			            out.println("<td>");
			            if (!courseName.isEmpty()) {
			                out.println(courseName);
			            } else {
			                out.println("&nbsp;"); // non-breaking space
			            }
			            out.println("</td>");
			        }
			        out.println("</tr>");
			    }
			  %>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>


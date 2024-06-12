<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.four.schedule.bean.ScheduleBean2,  java.lang.SuppressWarnings" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>課程時間表</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/schedule/css/SchedulePage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
</head>
<body class="schedulepage">
	<%@ include file="../../../../four/memberAdm/jsp/NavSide.jsp" %>
	<div class="main-block">
		<div class="scheduleListContainer">
			<h2>課程時間表</h2>
			<div class="btnLike">
			    <a href="${pageContext.request.contextPath}/CourseGetAll" class="link-btn1">查詢課程</a>
				<a href="${pageContext.request.contextPath}/ScheduleGetAll" class="link-btn2">查詢課表資料</a>			    
			</div>
			<table class="scheduleList">
			  <thead>
			    <tr>
				    <th>課程編號</th>
				    <th>課程名稱</th>
				    <th>星期一</th>
				    <th>星期二</th>
				    <th>星期三</th>
				    <th>星期四</th>
				    <th>星期五</th>
				    <th>星期六</th>
				    <th>星期日</th>
				    <th>教練編號</th>
				    <th>教練名稱</th>
			    </tr>
			  </thead>
			  <tbody>
			    <% 
			  	@SuppressWarnings("unchecked")
			    ArrayList<ScheduleBean2> schedules = (ArrayList<ScheduleBean2>)request.getAttribute("schedules");
			
			    String[] daytimes = {"Morning", "Afternoon", "Evening", "Night"};
			    String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			    for (ScheduleBean2 schedule : schedules) {
			        out.println("<tr>");
			        out.println("<td><b>" + schedule.getCourseId() + "</b></td>");
			        out.println("<td><b>" + schedule.getCourseName() + "</b></td>");
			        for (String weekday : weekdays) {
				        out.println("<td>");
			            String[] scheduleIds = schedule.getScheduleIds();
			            String[] weeks = schedule.getWeekdays();
			            String[] days = schedule.getDaytimes();
			            String w = "";
			            for (int i=0;i<schedule.getScheduleIds().length;i++){
				            if (weeks[i].equals(weekday)) { 
				            	if(w.isEmpty()){
									w=days[i];
					                out.println(w);
				            	}else{
									w=","+days[i];
					                out.println(w);				            		
				            	}
				            }
			            }
			        	out.println("</td>");
			        }
			        out.println("<td><b>" + schedule.getCoachId() + "</b></td>");
			        out.println("<td><b>" + schedule.getCoachName() + "</b></td>");
			        out.println("</tr>");
			    }
			  %>
			  </tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${directory}/four/memberAdm/js/app.js"></script>
</body>
</html>


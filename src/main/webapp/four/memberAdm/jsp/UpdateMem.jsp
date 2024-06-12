<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.four.memberAdm.bean.MemberBean, java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
    integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/nav_side_style.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/four/BackStageAllCss/BackStageAllPage.css">
<title>更新會員資料</title>
</head>
<body style="background-color:#fdf5e6">
<%@ include file="NavSide.jsp" %>
	<main  class="main-block">
		<div align="center">
			<h2>更新會員資料</h2><p class="empty"></p>
			<jsp:useBean id="member" scope="request" class="com.four.memberAdm.bean.MemberBean" />
			<div class="table-container">
				<form method="post" action="${pageContext.request.contextPath}/UpdateMem" enctype="multipart/form-data">
					
					<table class="member-table">
						<tr><td>會員編號<td><input type="text" name="memNo" readonly value="<%= member.getMemNo() %>">
						<tr><td>姓名<td><input type="text" name="memName" value="<%= member.getMemName() %>">
						<tr><td>Email<td><input type="text" name="memEmail" readonly value="<%= member.getMemEmail() %>">
						<tr><td>密碼<td><input type="password" name="memPassword" readonly value="<%= member.getMemPassword() %>">
						<tr><td>性別<td>
							<select name="gender" id="gender" value="<%= member.getGender() %>">  <!--下拉式選單-->
								<option value="0" <%= member.getGender() == 0 ? "selected" : "" %>>男性</option>
								<option value="1" <%= member.getGender() == 1 ? "selected" : "" %>>女性</option>
							</select>
						<tr><td>生日<td><input type="date" name="birth" value="<%= member.getBirth() %>">
						<tr><td>電話<td><input type="text" name="phone" value="<%= member.getPhone() %>">
						<tr><td>註冊日期<td><input type="text" name="regDate" readonly value="<%= member.getRegDate() %>">
						<tr><td>狀態<td>
								<select name="status" id="status" value="<%= member.getStatus() %>">  <!--下拉式選單-->
									<option value="0" <%= member.getStatus() == 0 ? "selected" : "" %>>未驗證</option>
									<option value="1" <%= member.getStatus() == 1 ? "selected" : "" %>>正常</option>
									<option value="2" <%= member.getStatus() == 2 ? "selected" : "" %>>封鎖</option>
								</select>
						<tr><td>暱稱<td><input type="text" name="nickName" value="<%= member.getNickName() %>">
						<tr><td>個人圖片<td>
							<% String base64Image = (member.getMemPic() != null) ? Base64.getEncoder().encodeToString(member.getMemPic()) : ""; %>
		    				<% if (!base64Image.isEmpty()) { %>
							<%-- <% if (member.getMemPic() != null) { %> --%>
							<img id="memPic" src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(member.getMemPic()) %>" width="100"/>
							<% } else {
			                        out.print(""); %>
			                        <img id="memPic" src="" width="100"/>
			                <% } %>
						<input type="file" name="memPic" accept="image/*" value="<%= base64Image %>" onchange="previewImage(event)">
						<input type="hidden" id="hiddenImage" name="hiddenImage" value="<%= base64Image %>">
					</table>
					<input class="btn" type="submit" value="確定" />
					<p class="empty"></p>
				</form>
			</div>
		</div>	
	</main>
	
	<script>
		// 預覽圖片
	    function previewImage(event) {
	        var reader = new FileReader();
	        reader.onload = function(){
	            var output = document.getElementById('memPic');
	            output.src = reader.result;
	            document.getElementById('hiddenImage').value = ""; // Clear the hidden input if a new image is selected
	        }
	        reader.readAsDataURL(event.target.files[0]);
	    }
	</script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/four/memberAdm/js/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/four/memberAdm/js/app.js"></script>
</body>
</html>
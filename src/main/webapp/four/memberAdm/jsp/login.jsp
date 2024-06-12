<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.four.memberAdm.bean.MemberBean" %>
<%! @SuppressWarnings("unchecked") %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gymnity - Login/Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/four/memberAdm/styles/login_style.css">
    
</head>
<body>
    <div class="container">
        <div class="form-container">
            <div class="form-toggle">
                <button id="loginBtn" class="active" onclick="showLogin()">Login</button>
                <button id="registerBtn" onclick="showRegister()">Register</button>
            </div>
            
            <form id="loginForm" class="form active" action="${pageContext.request.contextPath}/LoginAdm" method="post">
                <h2>Login</h2>
                <div class="form-group">
                    <label for="loginEmail">Email address</label>
                    <input type="email" id="loginEmail" placeholder="Enter email" name="admEmail">
                </div>
                <div class="form-group">
                    <label for="loginPassword">Password</label>
                    <input type="password" id="loginPassword" placeholder="Password" name="admPassword">
                </div>
                <button type="submit" class="btn">Login</button>
            </form>
            <form id="registerForm" class="form" action="${pageContext.request.contextPath}/RegisterMem" method="post">
                <h2>Register</h2>
                <div class="form-group">
                    <label for="registerName">姓名</label>
                    <input type="text" id="registerName" placeholder="Enter name" name="memName" required>
                </div>
                <div class="form-group">
                    <label for="registerEmail">Email address</label>
                    <input type="email" id="registerEmail" placeholder="Enter email" name="memEmail" required>
                </div>
                <div class="form-group">
                    <label for="registerPassword">Password</label>
                    <input type="password" id="registerPassword" placeholder="Password" name="memPassword" required>
                </div>
                <!-- <div class="form-group">
                    <label for="registerConfirmPassword">Confirm Password</label>
                    <input type="password" id="registerConfirmPassword" placeholder="Confirm Password" required>
                </div> -->
                <div class="form-group">
                    <label for="registerGender">性別</label>
					<select name="gender" id="registerGender" required>  <!--下拉式選單-->
						<option value="0">男性</option>
						<option value="1">女性</option>
					</select>
                </div>
                <div class="form-group">
                    <label for="registerBirth">生日</label>
                    <input type="date" id="registerBirth" name="birth" required>
                </div>
                <div class="form-group">
                    <label for="registerPhone">電話</label>
                    <input type="text" id="registerPhone" placeholder="Enter phone" name="phone" required>
                </div>
                <button type="button" class="btn" onclick="autoFill()">自動填入會員資料</button>
                <button type="submit" class="btn">Register</button>
            </form>

        </div>
    </div>
    <script>
        function showLogin() {
            const loginForm = document.getElementById('loginForm');
            const registerForm = document.getElementById('registerForm');

            loginForm.classList.add('active');
            registerForm.classList.remove('active');
            
            document.getElementById('loginBtn').classList.add('active');
            document.getElementById('registerBtn').classList.remove('active');
        }

        function showRegister() {
            const loginForm = document.getElementById('loginForm');
            const registerForm = document.getElementById('registerForm');

            registerForm.classList.add('active');
            loginForm.classList.remove('active');
            
            document.getElementById('loginBtn').classList.remove('active');
            document.getElementById('registerBtn').classList.add('active');
        }

        // 自動填入會員資料
        function autoFill() {
            document.getElementById('registerName').value = '陳大文';
            document.getElementById('registerEmail').value = 'dawen.chen@mail.com';
            document.getElementById('registerPassword').value = 'dawenchen';
            document.getElementById('registerGender').value = 1;
            document.getElementById('registerBirth').value = '1992-05-21';
            document.getElementById('registerPhone').value = '0933567890';
        }
    </script>

</body>
</html>

package com.four.memberAdm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.four.memberAdm.bean.MemberBean;
import com.four.memberAdm.bean.AdminBean;
import com.four.memberAdm.dao.AdminDao;
import com.four.memberAdm.dao.MemberDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/RegisterMem")
public class RegisterMem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDao adminDao = new AdminDao();
	MemberDao memberDao = new MemberDao();
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		
        String memName = request.getParameter("memName");
 		String memEmail = request.getParameter("memEmail");
 		String memPassword = request.getParameter("memPassword");
 		String genderStr = request.getParameter("gender");
 		String birth = request.getParameter("birth");
 		String phone = request.getParameter("phone");

        MemberBean member = new MemberBean();
        member.setMemName(memName);
        member.setMemEmail(memEmail);
        member.setMemPassword(memPassword);
        member.setGender(Integer.parseInt(genderStr));
        member.setBirth(birth);
        member.setPhone(phone);
        
        response.setContentType("text/html; charset=UTF-8");
        if (memberDao.registerMem(member)) {
        	response.getWriter().print("<script>alert('註冊成功！');window.location.href='four/memberAdm/jsp/login.jsp'</script>");
        } else {
        	response.getWriter().print("<script>alert('註冊失敗！');window.location.href='four/memberAdm/jsp/login.jsp'</script>");
        }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

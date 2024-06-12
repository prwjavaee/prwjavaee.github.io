package com.four.memberAdm.controller;

import java.io.IOException;
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


@WebServlet("/LogoutAdm")
public class LogoutAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDao adminDao = new AdminDao();
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		
 		HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("four/products/jsp/mall/HomePage.jsp");
 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

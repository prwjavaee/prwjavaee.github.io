package com.four.memberAdm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.four.memberAdm.bean.MemberBean;
import com.four.memberAdm.dao.MemberDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/BlockMem")
public class BlockMem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDao memberDao = new MemberDao();
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

 		String memNo = request.getParameter("memNo"); 		
 		memberDao.blockMem(memNo);
 		
 		request.getRequestDispatcher("/GetAllMems").forward(request, response);
 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

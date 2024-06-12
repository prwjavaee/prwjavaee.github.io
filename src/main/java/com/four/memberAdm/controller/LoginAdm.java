package com.four.memberAdm.controller;

import java.io.IOException;

import com.four.memberAdm.bean.MemberBean;
import com.four.memberAdm.dao.AdminDao;
import com.four.memberAdm.dao.MemberDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginAdm")
public class LoginAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDao adminDao = new AdminDao();
	MemberDao memberDao = new MemberDao();
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		String admEmail = request.getParameter("admEmail");
        String admPassword = request.getParameter("admPassword");
        String memEmail = admEmail;
        String memPassword = admPassword;
        MemberBean user = null;
        if (adminDao.validate(admEmail, admPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("admEmail", admEmail);
            response.sendRedirect("four/memberAdm/jsp/mgMem.jsp");
        } else if((user = memberDao.validate(memEmail, memPassword)) != null) {
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("four/memberAdm/jsp/welcome.jsp");
        } else {
            response.sendRedirect("four/memberAdm/jsp/login.jsp");
        }
 		
// 		String memNo = request.getParameter("memNo");
// 		MemberBean member =  memberDao.getMem(memNo);
// 		request.setAttribute("member", member);
// 		request.getRequestDispatcher("/four/jsp/GetMem.jsp")
// 			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

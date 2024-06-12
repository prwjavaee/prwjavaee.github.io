package com.four.coach.controller;

import java.io.IOException;

import com.four.coach.bean.CoachBean;
import com.four.coach.dao.CoachDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CoachUpdate")
public class CoachUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String coachId = request.getParameter("coachId");
		try {
			CoachBean coach = new CoachBean();
			CoachDao coachDao = new CoachDao();
			coach = coachDao.findById(coachId);
			request.setAttribute("coach", coach);
			request.getRequestDispatcher("/four/coach/jsp/CoachUpdate.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

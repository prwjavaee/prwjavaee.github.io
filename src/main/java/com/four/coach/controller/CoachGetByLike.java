package com.four.coach.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.four.coach.bean.CoachBean;
import com.four.coach.dao.CoachDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CoachGetByLike")
public class CoachGetByLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String likeword = request.getParameter("likeword");
		CoachDao coachdao = new CoachDao();
		List<CoachBean> coachs = new ArrayList<>();
		try {
			coachs = coachdao.findByWord(likeword);
			request.setAttribute("coachs", coachs);
			request.getRequestDispatcher("/four/coach/jsp/CoachGetAll.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

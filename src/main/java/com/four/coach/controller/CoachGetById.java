package com.four.coach.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.four.coach.bean.CoachBean;
import com.four.coach.dao.CoachDao;
import com.four.course.bean.CourseBean;
import com.four.course.dao.CourseDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CoachGetById")
public class CoachGetById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String coachId = request.getParameter("coachId");
		CoachBean coach = new CoachBean();
		CoachDao coachdao = new CoachDao();
		List<CourseBean> courses = new ArrayList<>();
		CourseDao courseDao = new CourseDao();
		try {
			coach = coachdao.findById(coachId);
			courses = courseDao.findByCoachId(coachId);
			request.setAttribute("courses", courses);
			request.setAttribute("coach", coach);
			request.getRequestDispatcher("/four/coach/jsp/CoachGetById.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

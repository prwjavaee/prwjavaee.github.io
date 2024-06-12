package com.four.schedule.controller;

import java.io.IOException;

import com.four.schedule.dao.ScheduleDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ScheduleDelete")
public class ScheduleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scheduleId = request.getParameter("scheduleId");
		String courseId = request.getParameter("courseId");
		try {
			ScheduleDao ScheduleDao = new ScheduleDao();
			ScheduleDao.delete(scheduleId);
			request.setAttribute("courseId", courseId);
			request.getRequestDispatcher("/ScheduleGetById").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.four.schedule.controller;

import java.io.IOException;

import com.four.schedule.bean.ScheduleBean;
import com.four.schedule.dao.ScheduleDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ScheduleInsert")
public class ScheduleInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ScheduleBean schedule = new ScheduleBean();
		ScheduleDao scheduleDao = new ScheduleDao();
		String courseId = request.getParameter("courseId");
		schedule.setCourseId(Integer.parseInt(request.getParameter("courseId")));
		schedule.setWeekday(request.getParameter("weekday"));
		schedule.setDaytime(request.getParameter("daytime"));
		scheduleDao.insert(schedule);
		request.setAttribute("courseId", courseId);
		request.getRequestDispatcher("/ScheduleGetById").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.four.schedule.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.four.schedule.bean.ScheduleBean;
import com.four.schedule.dao.ScheduleDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ScheduleShowByCourseId")
public class ScheduleShowByCourseId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<ScheduleBean> schedules = new ArrayList<>();
			ScheduleDao scheduleDao = new ScheduleDao();
			String courseId = request.getParameter("courseId");
			schedules = scheduleDao.findByCourseId(courseId);
			request.setAttribute("courseId", courseId);
			request.setAttribute("schedules", schedules);
			request.getRequestDispatcher("/four/schedule/jsp/ScheduleShowByCourseId.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

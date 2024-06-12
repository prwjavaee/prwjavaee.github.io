package com.four.course.controller;

import java.io.IOException;

import com.four.course.bean.CourseBean;
import com.four.course.dao.CourseDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseUpdate2")
public class CourseUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CourseBean course = new CourseBean();
			CourseDao courseDao = new CourseDao();
			course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
			course.setCourseName(request.getParameter("courseName"));
			course.setCourseProfile(request.getParameter("courseProfile"));
			course.setCoachId(Integer.parseInt(request.getParameter("coachId")));
			courseDao.update(course);
			request.getRequestDispatcher("/CourseGetAll").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

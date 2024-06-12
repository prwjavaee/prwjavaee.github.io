package com.four.course.controller;

import java.io.IOException;

import com.four.course.bean.CourseBean;
import com.four.course.dao.CourseDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseGetById")
public class CourseGetById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseId = request.getParameter("courseId");
		CourseDao courseDao = new CourseDao();
		CourseBean course = new CourseBean();
		try {
			course = courseDao.findById(courseId);
			request.setAttribute("course", course);
			request.getRequestDispatcher("/four/course/jsp/CourseGetById.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

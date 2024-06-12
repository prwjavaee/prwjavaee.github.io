package com.four.course.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.four.course.bean.CourseBean;
import com.four.course.dao.CourseDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CourseGetAll")
public class CourseGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<CourseBean> courses = new ArrayList<>();
			CourseDao coursedao = new CourseDao();
			courses = coursedao.findAll();
			request.setAttribute("courses", courses);
			request.getRequestDispatcher("/four/course/jsp/CourseGetAll.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

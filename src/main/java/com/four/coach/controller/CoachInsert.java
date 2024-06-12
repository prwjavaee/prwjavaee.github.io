package com.four.coach.controller;

import java.io.IOException;

import com.four.coach.bean.CoachBean;
import com.four.coach.dao.CoachDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/CoachInsert")
@MultipartConfig
public class CoachInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoachBean coach = new CoachBean();
		CoachDao coachdao = new CoachDao();
		coach.setCoachName(request.getParameter("coachName"));
		coach.setCoachJob(request.getParameter("coachJob"));
		coach.setCoachProfile(request.getParameter("coachProfile"));
		Part part = request.getPart("coachPic");
		part.write(getServletContext().getRealPath("/four/coach/images/") + part.getSubmittedFileName());
		coach.setCoachPic(part.getSubmittedFileName());
		coachdao.insert(coach);
		request.getRequestDispatcher("/CoachGetAll").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

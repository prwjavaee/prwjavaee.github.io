package com.four.article.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

import com.four.article.bean.ArticleBean;
import com.four.article.dao.ArticleDAO;

@WebServlet("/GetArticlesByTitle")
public class GetArticlesByTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		ArticleDAO articleDAO = new ArticleDAO();
		List<ArticleBean> allArticles = articleDAO.getArticlesByTitle(title);
		request.setAttribute("allArticles", allArticles);
		request.getRequestDispatcher("/four/article/jsp/GetAllArticles.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

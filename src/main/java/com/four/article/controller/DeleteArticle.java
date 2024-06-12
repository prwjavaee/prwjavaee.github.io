package com.four.article.controller;

import java.io.IOException;

import com.four.article.dao.ArticleDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteArticle")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleID = request.getParameter("articleID");
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.deleteArticle(Integer.parseInt(articleID));	
		request.getRequestDispatcher("/GetAllArticles").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

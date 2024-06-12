package com.four.article.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import com.four.article.bean.ArticleBean;
import com.four.article.dao.ArticleDAO;

@WebServlet("/UpdateArticle1")
public class UpdateArticle1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleID = request.getParameter("articleID");
		ArticleDAO articleDAO = new ArticleDAO();
		ArticleBean updateArticles = new ArticleBean();
		updateArticles = articleDAO.getArticleByArticleID(articleID);
		//查詢欲修改的資料 把取得的資料傳回給使用者修改(標題、標籤、內容) 
		request.setAttribute("updateArticle", updateArticles);
		request.getRequestDispatcher("/four/article/jsp/UpdateArticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

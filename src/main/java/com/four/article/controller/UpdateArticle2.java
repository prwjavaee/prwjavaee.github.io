package com.four.article.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.four.article.bean.ArticleBean;
import com.four.article.dao.ArticleDAO;

@WebServlet("/UpdateArticle2")
public class UpdateArticle2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleID = request.getParameter("articleID");
		String tag = request.getParameter("tag");
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");

		ArticleDAO articleDAO = new ArticleDAO();
		ArticleBean articleBean = new ArticleBean();
		articleBean = articleDAO.getArticleByArticleID(articleID);

		articleBean.setTag(tag);
		articleBean.setArticleTitle(articleTitle);
		articleBean.setArticleContent(articleContent);
		articleDAO.updateArticle(articleBean);
		request.getRequestDispatcher("/GetAllArticles").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

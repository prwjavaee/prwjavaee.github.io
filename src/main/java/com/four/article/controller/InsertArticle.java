package com.four.article.controller;

import java.io.IOException;

import com.four.article.bean.ArticleBean;
import com.four.article.dao.ArticleDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertArticle")
public class InsertArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArticleBean articleBean = new ArticleBean();
		String memberID = request.getParameter("memberID");
		String articleTitle = request.getParameter("articleTitle");
		String postTime = request.getParameter("postTime");
		String tag = request.getParameter("tag");
		String articleDisplay = request.getParameter("articleDisplay");
		String articleContent = request.getParameter("articleContent");
		
		articleBean.setMemberID(Integer.parseInt(memberID));
		articleBean.setArticleTitle(articleTitle);
//		articleBean.setPostTime(Timestamp.valueOf(postTime));
		articleBean.setPostTime(postTime);
		articleBean.setTag(tag);
		articleBean.setArticleDisplay(articleDisplay);
		articleBean.setArticleContent(articleContent);
		
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.insertArticle(articleBean);
		request.getRequestDispatcher("/GetAllArticles").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

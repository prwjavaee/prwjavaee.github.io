package com.four.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.four.article.bean.ArticleBean;
import com.four.util.ConnectionPool;


public class ArticleDAO {

	//查詢全部文章
	public List<ArticleBean> getAllArticles(){
		
		String sql = "SELECT * FROM　article";
		List<ArticleBean> articleList = new ArrayList<ArticleBean>();
		Connection getconnection = ConnectionPool.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = getconnection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int articleId = resultSet.getInt("articleID");
				int memberID = resultSet.getInt("memberID");
				Timestamp postTime = resultSet.getTimestamp("postTime");
				postTime.setNanos(0);
				String StringOfPostTime = postTime.toString();
				String modifiedPostTime = StringOfPostTime.substring(0, StringOfPostTime.length() - 2);
				//在DAO中把timestamp型態轉成字串型態處理毫秒 並以字串型態放在bean中 			
				String tag = resultSet.getString("tag");
				String articleTitle = resultSet.getString("articleTitle");
				String articleContent = resultSet.getString("articleContent");
				String articleDisplay = resultSet.getString("articleDisplay");
				
				ArticleBean ArticleBean = new ArticleBean();
				ArticleBean.setArticleID(articleId);
				ArticleBean.setMemberID(memberID);
				ArticleBean.setPostTime(modifiedPostTime);
				ArticleBean.setTag(tag);
				ArticleBean.setArticleTitle(articleTitle);
				ArticleBean.setArticleContent(articleContent);
				ArticleBean.setArticleDisplay(articleDisplay);
				
				articleList.add(ArticleBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(getconnection, statement, resultSet);
		}
		return articleList;
	}
	
	//查詢多筆文章(模糊查詢)
	public List<ArticleBean> getArticlesByTitle(String title) {
		String sql = "SELECT * FROM article WHERE articleTitle LIKE ?";
		List<ArticleBean> articleList = new ArrayList<ArticleBean>();
		Connection getconnection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = getconnection.prepareStatement(sql);
			String fuzzyQueryTitle = "%" + title +"%";
			preparedStatement.setString(1, fuzzyQueryTitle);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int articleId = resultSet.getInt("articleID");
				int memberID = resultSet.getInt("memberID");
				Timestamp postTime = resultSet.getTimestamp("postTime");
				postTime.setNanos(0);
				String StringOfPostTime = postTime.toString();
				String modifiedPostTime = StringOfPostTime.substring(0, StringOfPostTime.length() - 2);
				//在DAO把timestamp型態轉成字串 型態處理毫秒 並以字串型態放在bean中 	
				String tag = resultSet.getString("tag");
				String articleTitle = resultSet.getString("articleTitle");
				String articleContent = resultSet.getString("articleContent");
				String articleDisplay = resultSet.getString("articleDisplay");
				
				ArticleBean ArticleBean = new ArticleBean();
				ArticleBean.setArticleID(articleId);
				ArticleBean.setMemberID(memberID);
				ArticleBean.setPostTime(modifiedPostTime);
				ArticleBean.setTag(tag);
				ArticleBean.setArticleTitle(articleTitle);
				ArticleBean.setArticleContent(articleContent);
				ArticleBean.setArticleDisplay(articleDisplay);			
				articleList.add(ArticleBean);
			}
			return articleList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(getconnection, preparedStatement, resultSet);
		}
		return null;
	}
	
	//查詢單筆文章
	public ArticleBean getArticleByArticleID(String articleID) {
		String sql = "SELECT * FROM article WHERE articleID = ?";
		Connection getconnection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = getconnection.prepareStatement(sql);
			preparedStatement.setString(1, articleID);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int articleId = resultSet.getInt("articleID");
			int memberID = resultSet.getInt("memberID");
			Timestamp postTime = resultSet.getTimestamp("postTime");
			postTime.setNanos(0);
			String StringOfPostTime = postTime.toString();
			String modifiedPostTime = StringOfPostTime.substring(0, StringOfPostTime.length() - 2);
			//在DAO把timestamp型態轉成字串 型態處理毫秒 並以字串型態放在bean中 	
			String tag = resultSet.getString("tag");
			String articleTitle = resultSet.getString("articleTitle");
			String articleContent = resultSet.getString("articleContent");
			String articleDisplay = resultSet.getString("articleDisplay");
			
			ArticleBean ArticleBean = new ArticleBean();
			ArticleBean.setArticleID(articleId);
			ArticleBean.setMemberID(memberID);
			ArticleBean.setPostTime(modifiedPostTime);
			ArticleBean.setTag(tag);
			ArticleBean.setArticleTitle(articleTitle);
			ArticleBean.setArticleContent(articleContent);
			ArticleBean.setArticleDisplay(articleDisplay);
			return ArticleBean;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(getconnection, preparedStatement, resultSet);
		}
		return null;
	}
	
	//刪除文章
	public void deleteArticle(Integer articleid) {
		String sql = "DELETE FROM article WHERE articleID = ?";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleid);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, preparedStatement);
		}
	}
	
	//新增一筆文章
	public void insertArticle(ArticleBean articleBean) {

		String sql = "INSERT INTO article"
				+ "(memberID, postTime, tag, articleTitle, articleContent, articleDisplay) "
				+ "VALUES(?,?,?,?,?,?)";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleBean.getMemberID());
			preparedStatement.setString(2, articleBean.getPostTime());
			preparedStatement.setString(3, articleBean.getTag());
			preparedStatement.setString(4, articleBean.getArticleTitle());
			preparedStatement.setString(5, articleBean.getArticleContent());
			preparedStatement.setString(6, articleBean.getArticleDisplay());
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, preparedStatement);
		}
	}
	//修改文章內容
	public void updateArticle(ArticleBean article) {
		String sql = "UPDATE article SET tag=?, articleTitle=?, articleContent=? WHERE articleID = ?";
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, article.getTag());
			preparedStatement.setString(2, article.getArticleTitle());
			preparedStatement.setString(3, article.getArticleContent());
			preparedStatement.setInt(4, article.getArticleID());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, preparedStatement);
		}
	}
}
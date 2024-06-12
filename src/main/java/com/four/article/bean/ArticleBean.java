package com.four.article.bean;

import java.io.Serializable;

public class ArticleBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int articleID;
	private int memberID;
	private String postTime;
	private String tag;
	private String articleTitle;
	private String articleContent;
	private String articleDisplay;
	
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getArticleDisplay() {
		return articleDisplay;
	}
	public void setArticleDisplay(String articleDisplay) {
		this.articleDisplay = articleDisplay;
	}
}

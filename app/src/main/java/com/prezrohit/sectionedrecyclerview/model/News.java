package com.prezrohit.sectionedrecyclerview.model;

import com.prezrohit.sectionedrecyclerview.dto.Article;

import java.util.List;

public class News {
	private final String sourceName;
	private final List<Article> articleList;

	public News(String sourceName, List<Article> articleList) {
		this.sourceName = sourceName;
		this.articleList = articleList;
	}

	public String getSourceName() {
		return sourceName;
	}

	public List<Article> getArticleList() {
		return articleList;
	}
}

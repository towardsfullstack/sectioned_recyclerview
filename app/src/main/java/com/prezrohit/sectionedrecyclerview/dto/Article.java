package com.prezrohit.sectionedrecyclerview.dto;

import com.google.gson.annotations.SerializedName;

public class Article {

	@SerializedName("source")
	private Source source;

	@SerializedName("author")
	private String author;

	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private String description;

	@SerializedName("url")
	private String url;

	@SerializedName("urlToImage")
	private String urlToImage;

	@SerializedName("publishedAt")
	private String publishedAt;

	@SerializedName("content")
	private String content;

	public Source getSource() {
		return source;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Article{" +
				"source=" + source +
				", author='" + author + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", url='" + url + '\'' +
				", urlToImage='" + urlToImage + '\'' +
				", publishedAt='" + publishedAt + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}

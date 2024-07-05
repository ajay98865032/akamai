package com.ajay.spring.jpa.h2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SOCIALNETWORK")
public class SocialNetworkPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "AUTHOR")
	String author;

	@Column(name = "CONTENT")
	String content;
	
	@Column(name = "POST_CATEGORY")
	String postCategory;
	
	@Column(name = "POST_DATE")
	String postDate;

	@Column(name = "VIEW_COUNT")
	String viewCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	public SocialNetworkPost(long id, String author, String content, String postCategory, String postDate,
			String viewCount) {
		super();
		this.id = id;
		this.author = author;
		this.content = content;
		this.postCategory = postCategory;
		this.postDate = postDate;
		this.viewCount = viewCount;
	}

	public SocialNetworkPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}

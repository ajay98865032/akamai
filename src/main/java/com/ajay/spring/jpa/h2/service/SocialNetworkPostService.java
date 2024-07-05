package com.ajay.spring.jpa.h2.service;

import java.util.List;



import com.ajay.spring.jpa.h2.model.SocialNetworkPost;



public interface SocialNetworkPostService 
{
	
	List<SocialNetworkPost> getAuthors(String author);
	
	List<SocialNetworkPost> getViewCounts(String postCategory);

}

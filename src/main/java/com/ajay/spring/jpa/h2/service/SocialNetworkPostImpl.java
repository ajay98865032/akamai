package com.ajay.spring.jpa.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.spring.jpa.h2.model.SocialNetworkPost;
import com.ajay.spring.jpa.h2.repository.SocialNetworkPostRepository;

@Service
public class SocialNetworkPostImpl implements SocialNetworkPostService {

	@Autowired
	SocialNetworkPostRepository socialNetworkPostRepository;

	@Override
	public List<SocialNetworkPost> getAuthors(String author) {
		List<SocialNetworkPost> authors = socialNetworkPostRepository.findByAuthor(author);
		return authors;
	}

	@Override
	public List<SocialNetworkPost> getViewCounts(String postCategory) {
		List<SocialNetworkPost> authorsList = socialNetworkPostRepository
				.findTop10ByPostCategoryOrderByViewCountDesc(postCategory);
		return authorsList;
	}

}

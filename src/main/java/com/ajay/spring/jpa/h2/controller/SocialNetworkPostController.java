package com.ajay.spring.jpa.h2.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ajay.spring.jpa.h2.model.SocialNetworkPost;

import com.ajay.spring.jpa.h2.service.SocialNetworkPostService;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/social")
public class SocialNetworkPostController {

	@Autowired
	SocialNetworkPostService socialNetworkPostService;

	@GetMapping("/getpostsbyauthor")
	public ResponseEntity<List<SocialNetworkPost>> searchPostsByAuthor(@RequestParam("author") String author) {
		try {

			List<SocialNetworkPost> authors = socialNetworkPostService.getAuthors(author);

			if (authors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(authors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getviewcountsbycategory")
	public ResponseEntity<List<SocialNetworkPost>> getViewCountsByCategory(
			@RequestParam("postCategory") String postCategory) {
		try {

			List<SocialNetworkPost> authors = socialNetworkPostService.getViewCounts(postCategory);

			if (authors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(authors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

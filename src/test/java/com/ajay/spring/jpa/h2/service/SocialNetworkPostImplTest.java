package com.ajay.spring.jpa.h2.service;

import com.ajay.spring.jpa.h2.model.SocialNetworkPost;
import com.ajay.spring.jpa.h2.repository.SocialNetworkPostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class SocialNetworkPostImplTest {

	@Mock
	private SocialNetworkPostRepository socialNetworkPostRepository;

	@InjectMocks
	private SocialNetworkPostImpl socialNetworkPostService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAuthors_ReturnsPosts() {
		SocialNetworkPost post = new SocialNetworkPost();
		post.setAuthor("Alice");
		post.setPostCategory("Music");
		post.setContent("Check out my new song!.");

		when(socialNetworkPostRepository.findByAuthor(anyString())).thenReturn(Collections.singletonList(post));

		List<SocialNetworkPost> result = socialNetworkPostService.getAuthors("Alice");

		assertEquals(1, result.size());
		assertEquals("Alice", result.get(0).getAuthor());
	}

	@Test
	public void testGetAuthors_ReturnsNoPosts() {
		when(socialNetworkPostRepository.findByAuthor(anyString())).thenReturn(Collections.emptyList());

		List<SocialNetworkPost> result = socialNetworkPostService.getAuthors("Unknown Author");

		assertEquals(0, result.size());
	}

	@Test
	public void testGetViewCounts_ReturnsPosts() {
		SocialNetworkPost post = new SocialNetworkPost();
		post.setPostCategory("Music");
		post.setViewCount("2850");

		when(socialNetworkPostRepository.findTop10ByPostCategoryOrderByViewCountDesc(anyString()))
				.thenReturn(Arrays.asList(post));

		List<SocialNetworkPost> result = socialNetworkPostService.getViewCounts("Music");

		assertEquals(1, result.size());
		assertEquals("Music", result.get(0).getPostCategory());
		assertEquals("2850", result.get(0).getViewCount());
	}

	@Test
	public void testGetViewCounts_ReturnsNoPosts() {
		when(socialNetworkPostRepository.findTop10ByPostCategoryOrderByViewCountDesc(anyString()))
				.thenReturn(Collections.emptyList());

		List<SocialNetworkPost> result = socialNetworkPostService.getViewCounts("Unknown Category");

		assertEquals(0, result.size());
	}
}

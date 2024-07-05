package com.ajay.spring.jpa.h2.controller;

import com.ajay.spring.jpa.h2.model.SocialNetworkPost;
import com.ajay.spring.jpa.h2.service.SocialNetworkPostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SocialNetworkPostControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@MockBean
	private SocialNetworkPostService socialNetworkPostService;

	@Test
	public void searchPostsByAuthor_ReturnsPosts() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		SocialNetworkPost post = new SocialNetworkPost();
		post.setAuthor("Alice");
		post.setPostCategory("Music");
		post.setContent("Check out my new song!.");

		when(socialNetworkPostService.getAuthors(anyString())).thenReturn(Collections.singletonList(post));

		mockMvc.perform(
				get("/social/getpostsbyauthor").param("author", "Alice").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].author").value("Alice"));
	}

	@Test
	public void searchPostsByAuthor_ReturnsNoContent() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		when(socialNetworkPostService.getAuthors(anyString())).thenReturn(Collections.emptyList());

		mockMvc.perform(get("/social/getpostsbyauthor").param("author", "Unknown Author")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	public void getViewCountsByCategory_ReturnsPosts() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		SocialNetworkPost post = new SocialNetworkPost();
		post.setPostCategory("Music");
		post.setViewCount("2850");

		when(socialNetworkPostService.getViewCounts(anyString())).thenReturn(Arrays.asList(post));

		mockMvc.perform(get("/social/getviewcountsbycategory").param("postCategory", "Music")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].postCategory").value("Music"))
				.andExpect(jsonPath("$[0].viewCount").value(2850));
	}

	@Test
	public void getViewCountsByCategory_ReturnsNoContent() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		when(socialNetworkPostService.getViewCounts(anyString())).thenReturn(Collections.emptyList());

		mockMvc.perform(get("/social/getviewcountsbycategory").param("postCategory", "Unknown Category")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
}
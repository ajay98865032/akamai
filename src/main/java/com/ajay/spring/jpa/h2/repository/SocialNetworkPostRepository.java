package com.ajay.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ajay.spring.jpa.h2.model.SocialNetworkPost;
import java.util.List;

public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

	List<SocialNetworkPost> findByAuthor(String author);
	
	
	    @Query("SELECT p FROM SocialNetworkPost p WHERE p.postCategory = :postCategory ORDER BY p.viewCount DESC")
	    List<SocialNetworkPost> findTop10ByPostCategoryOrderByViewCountDesc(@Param("postCategory") String postCategory);

}

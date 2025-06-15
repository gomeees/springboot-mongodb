package com.motosimagab.springboot_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.motosimagab.springboot_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	List<Post> findByTitleContainingIgnoringCase(String text); // query methods
	
}

package com.motosimagab.springboot_mongodb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.motosimagab.springboot_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//https://www.mongodb.com/pt-br/docs/manual/reference/operator/query/
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") // /0 = primeiro parametro do método
	List<Post> searchTitle(String text); // consulta personalizada
	
	//https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	List<Post> findByTitleContainingIgnoringCase(String text); // query methods
	
	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);
}
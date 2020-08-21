package com.example.polls.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.polls.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
//	@Query("SELECT T FROM Topic T WHERE T.categoryId =:categoryId")
//	Optional<Topic> findTopicByCourseId(@RequestParam("categoryId") String categoryId);
//
//	@Query("SELECT T FROM Topic T WHERE T.categoryId =:categoryId")
//	List<Topic> findTopicsByCourseId(@RequestParam("categoryId") String categoryId);
}

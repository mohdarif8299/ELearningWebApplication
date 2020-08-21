package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.polls.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("SELECT C FROM  Category C WHERE C.courseId =:courseId")
	List<Category> findCategoryByCourseId(@RequestParam("courseId") String courseId);
}

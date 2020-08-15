package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.polls.model.CourseTitle;

@Repository
public interface CoursesTitleRepository extends JpaRepository<CourseTitle, Long> {
	@Query("SELECT C FROM CourseTitle C WHERE C.categoryId =:categoryId")
	List<CourseTitle> findCoursebyCourseId(@RequestParam("categoryId") String categoryId);
}

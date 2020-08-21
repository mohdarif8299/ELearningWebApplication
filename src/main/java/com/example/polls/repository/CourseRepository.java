package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.polls.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query("SELECT C FROM Course C WHERE C.username =:username")
	List<Course> findCourseByUsername(@RequestParam("username") String username);
}

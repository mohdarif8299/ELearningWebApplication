package com.example.polls.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Category;
import com.example.polls.model.Course;
import com.example.polls.model.CourseTitle;
import com.example.polls.repository.CategoryRepository;
import com.example.polls.repository.CoursesRepository;
import com.example.polls.repository.CoursesTitleRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
	private CoursesTitleRepository coursesTitleRepository;
	@Autowired
	private CoursesRepository coursesRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("/allcourses")
	public List<CourseTitle> getAllCourses() {
		return coursesTitleRepository.findAll();
	}

	@PostMapping("/allcategories")
	private List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	@PostMapping("/course")
	public Optional<Course> getCourseById(@RequestParam("courseId") String courseId) {
		System.out.println("API CALLED");
		return coursesRepository.findCoursebyCourseId(courseId);
	}
	@PostMapping("/coursetitles")
	public List<CourseTitle> getCourseTitlesByCategoryId(@RequestParam("categoryId") String categoryId) {
		System.out.println("API CALLED");
		return coursesTitleRepository.findCoursebyCourseId(categoryId);
	}

}

package com.example.polls.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.polls.model.Category;
import com.example.polls.model.Course;
import com.example.polls.model.Topic;
import com.example.polls.repository.CategoryRepository;
import com.example.polls.repository.CourseRepository;
import com.example.polls.repository.TopicRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private CourseRepository coursesRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("/course")
	public List<Course> getAllCourses(@RequestParam("username") String username) {
		return coursesRepository.findCourseByUsername(username);
	}

	@PostMapping("/category")
	public List<Category> getCoutegoryByCourseId(@RequestParam("courseId") String courseId) {
		return categoryRepository.findCategoryByCourseId(courseId);
	}

	@PostMapping("/topic")
	public Optional<Topic> getTopicByCategoryId(@RequestParam("topicId") String topicId) {
		return topicRepository.findById(Long.parseLong(topicId));
	}

	@GetMapping("/video")
	public void get(HttpServletResponse response) throws IOException, URISyntaxException {
		System.out.println("CALLED");
		 RestTemplate restTemplate = new RestTemplate();
		    restTemplate.execute(            
		        URI.create("https://cskaabucket.s3.ap-south-1.amazonaws.com/Ro4zM8WL9RspLqEL.mp4"),            
		        HttpMethod.GET,            
		        (ClientHttpRequest request) -> {},            
		        responseExtractor -> {                
		            response.setContentType("video/mp4");                
		            IOUtils.copy(responseExtractor.getBody(), response.getOutputStream());                
		            return null;            
		        }
		    ); 
	}
}
//	
//	@PostMapping("/topics")
//	public List<Topic> getTopicsByCategoryId(@RequestParam("categoryId") String categoryId) {
//		return topicRepository.findTopicsByCourseId(categoryId);
//	}

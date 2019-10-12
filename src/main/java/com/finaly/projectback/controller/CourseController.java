package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.entity.CourseEntity;
import com.finaly.projectback.entity.UserEntity;
import com.finaly.projectback.repo.CourseRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/courses")
	@ResponseBody
	public List<CourseEntity> getCourses() {
		return (List<CourseEntity>) courseRepository.findAll();
	}

	// findByUserId
//	@GetMapping("courses/{id}")
//	public CourseEntity findByUserId(int user_entity_user_id) {
//		return courseRepository.findByUserId(user_entity_user_id);
//	}

	@PostMapping("/courses")
	void addCourse(@RequestBody CourseEntity course) {
		CourseEntity courseEntity = new CourseEntity();
		UserEntity userEntity = new UserEntity();
		courseEntity.setUserEntity(userEntity);

		courseRepository.save(course);
	}
}

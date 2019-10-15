package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.Enrollment;
import com.finaly.projectback.repo.EnrollmentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class EnrollmentController {

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@GetMapping("/enrollments")
	@ResponseBody
	public List<Enrollment> getEnrollements() {
		return (List<Enrollment>) enrollmentRepository.findAll();
	}

	@PostMapping("/enrollments")
	void addEnrollment(@RequestBody Enrollment enrollment) {
		enrollmentRepository.save(enrollment);
	}
}

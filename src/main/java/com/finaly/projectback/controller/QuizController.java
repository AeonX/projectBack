package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.Quiz;
import com.finaly.projectback.repo.QuizRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class QuizController {

	@Autowired
	private QuizRepository quizRepository;
	
	@GetMapping("/quizzes")
	@ResponseBody
	public List<Quiz> getQuizQuestions() {
		return (List<Quiz>) quizRepository.findAll();
	}

	@PostMapping("/quizzes")
	void addQuizQuestion(@RequestBody Quiz quiz) {
		quizRepository.save(quiz);
	}
	
}

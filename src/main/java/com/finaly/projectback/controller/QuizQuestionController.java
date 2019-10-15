package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.QuizQuestion;
import com.finaly.projectback.repo.QuizQuestionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class QuizQuestionController {

	@Autowired
	private QuizQuestionRepository quizQuestionRepository;
	
	@GetMapping("/quizQuestions")
	@ResponseBody
	public List<QuizQuestion> getQuizQuestions() {
		return (List<QuizQuestion>) quizQuestionRepository.findAll();
	}

	@PostMapping("/quizQuestions")
	void addQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
		quizQuestionRepository.save(quizQuestion);
	}
}

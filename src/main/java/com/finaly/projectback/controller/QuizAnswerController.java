package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.QuizAnswer;
import com.finaly.projectback.repo.QuizAnswerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class QuizAnswerController {

	@Autowired
	private QuizAnswerRepository quizAnswerRepository;
	
	@GetMapping("/quizAnswers")
	@ResponseBody
	public List<QuizAnswer> getModules() {
		return (List<QuizAnswer>) quizAnswerRepository.findAll();
	}

	@PostMapping("/quizAnswers")
	void addQuizAnswer(@RequestBody QuizAnswer quizAnswer) {
		quizAnswerRepository.save(quizAnswer);
	}
}

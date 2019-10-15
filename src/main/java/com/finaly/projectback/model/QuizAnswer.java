package com.finaly.projectback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="web_quiz_answer", schema="project")
public class QuizAnswer {
	
	public QuizAnswer() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long quiz_answer_id;
	
	@Column(name="answer")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="quiz_question_id")
	private QuizQuestion quizQuestion;

	public Long getQuiz_answer_id() {
		return quiz_answer_id;
	}

	public void setQuiz_answer_id(Long quiz_answer_id) {
		this.quiz_answer_id = quiz_answer_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

	public QuizAnswer(Long quiz_answer_id, String answer, QuizQuestion quizQuestion) {
		super();
		this.quiz_answer_id = quiz_answer_id;
		this.answer = answer;
		this.quizQuestion = quizQuestion;
	}

	@Override
	public String toString() {
		return "QuizAnswer [quiz_answer_id=" + quiz_answer_id + ", answer=" + answer + ", quizQuestion=" + quizQuestion
				+ "]";
	}
}

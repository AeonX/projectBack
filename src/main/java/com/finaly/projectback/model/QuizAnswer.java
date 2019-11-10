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
	
	@Column(name="answer1")
	private String answer1;
	
	@Column(name="answer2")
	private String answer2;
	
	@Column(name="answer3")
	private String answer3;
	
	@Column(name="answer4")
	private String answer4;
	
	@Column(name="correct_answer")
	private boolean correct_answer;
	
	
	
	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public boolean isCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(boolean correct_answer) {
		this.correct_answer = correct_answer;
	}

	@ManyToOne
	@JoinColumn(name="quiz_question_id")
	private QuizQuestion quizQuestion;

	public Long getQuiz_answer_id() {
		return quiz_answer_id;
	}

	public void setQuiz_answer_id(Long quiz_answer_id) {
		this.quiz_answer_id = quiz_answer_id;
	}

	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

	public QuizAnswer(Long quiz_answer_id, String answer1, String answer2, String answer3, String answer4,
			boolean correct_answer, QuizQuestion quizQuestion) {
		super();
		this.quiz_answer_id = quiz_answer_id;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correct_answer = correct_answer;
		this.quizQuestion = quizQuestion;
	}

	@Override
	public String toString() {
		return "QuizAnswer [quiz_answer_id=" + quiz_answer_id + ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + ", answer4=" + answer4 + ", correct_answer=" + correct_answer
				+ ", quizQuestion=" + quizQuestion + "]";
	}

	
}

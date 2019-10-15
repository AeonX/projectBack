package com.finaly.projectback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="web_quiz_question", schema="project")
public class QuizQuestion {
	
	public QuizQuestion() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long quiz_question_id;
	
	@Column(name="question")
	private String question;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course courseQuizQuestion;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module moduleQuizQuestion;

	public Long getQuiz_question_id() {
		return quiz_question_id;
	}

	public void setQuiz_question_id(Long quiz_question_id) {
		this.quiz_question_id = quiz_question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Course getCourseQuizQuestion() {
		return courseQuizQuestion;
	}

	public void setCourseQuizQuestion(Course courseQuizQuestion) {
		this.courseQuizQuestion = courseQuizQuestion;
	}

	public Module getModuleQuizQuestion() {
		return moduleQuizQuestion;
	}

	public void setModuleQuizQuestion(Module moduleQuizQuestion) {
		this.moduleQuizQuestion = moduleQuizQuestion;
	}

	public QuizQuestion(Long quiz_question_id, String question, Course courseQuizQuestion, Module moduleQuizQuestion) {
		super();
		this.quiz_question_id = quiz_question_id;
		this.question = question;
		this.courseQuizQuestion = courseQuizQuestion;
		this.moduleQuizQuestion = moduleQuizQuestion;
	}

	@Override
	public String toString() {
		return "QuizQuestion [quiz_question_id=" + quiz_question_id + ", question=" + question + ", courseQuizQuestion="
				+ courseQuizQuestion + ", moduleQuizQuestion=" + moduleQuizQuestion + "]";
	}
	
	@OneToMany(mappedBy = "quizQuestion")
	private List<QuizAnswer> quizQuestions = new ArrayList<QuizAnswer>();
	
	public void addQuizAnswer(QuizAnswer quizAnswer) {
		this.quizQuestions.add(quizAnswer);
		quizAnswer.setQuizQuestion(this);
	}
}

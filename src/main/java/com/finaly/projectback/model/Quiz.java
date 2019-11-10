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
@Table(name="web_quiz", schema="project")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long quiz_id;
	
	@Column(name="quiz_name")
	private String quiz_name;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course courseQuiz;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module moduleQuiz;

	public Long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(Long quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getQuiz_name() {
		return quiz_name;
	}

	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}

	public Course getCourseQuiz() {
		System.out.println(courseQuiz + " poiu");
		return courseQuiz;
	}

	public void setCourseQuiz(Course courseQuiz) {
		this.courseQuiz = courseQuiz;
	}

	public Module getModuleQuiz() {
		return moduleQuiz;
	}

	public void setModuleQuiz(Module moduleQuiz) {
		this.moduleQuiz = moduleQuiz;
	}
	
	public Quiz() {
	}

	public Quiz(Long quiz_id, String quiz_name, Course courseQuiz, Module moduleQuiz) {
		super();
		System.out.println("constructor " + courseQuiz);
		this.quiz_id = quiz_id;
		this.quiz_name = quiz_name;
		this.courseQuiz = courseQuiz;
		this.moduleQuiz = moduleQuiz;
	}

	@Override
	public String toString() {
		return "Quiz [quiz_id=" + quiz_id + ", quiz_name=" + quiz_name + ", courseQuiz=" + courseQuiz + ", moduleQuiz="
				+ moduleQuiz + "]";
	}
//	
//	@OneToMany(mappedBy = "quizQuizQuestion")
//	private List<QuizQuestion> quizQuizQuestions = new ArrayList<QuizQuestion>();
//	
//	public void addCourseQuiz(QuizQuestion quizQuizQuestion) {
//		this.quizQuizQuestions.add(quizQuizQuestion);
//		quizQuizQuestion.setQuizQuizQuestion(this);
//	}
//	
	
}

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
@Table(name="web_user_quiz_answer", schema="project")
public class UserQuizAnswer {
	
	public UserQuizAnswer() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long user_quiz_question_answer;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private User userQuizAnswer;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course courseQuizAnswer;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module moduleQuizAnswer;

	public Long getUser_quiz_question_answer() {
		return user_quiz_question_answer;
	}

	public void setUser_quiz_question_answer(Long user_quiz_question_answer) {
		this.user_quiz_question_answer = user_quiz_question_answer;
	}

	public User getUserQuizAnswer() {
		return userQuizAnswer;
	}

	public void setUserQuizAnswer(User userQuizAnswer) {
		this.userQuizAnswer = userQuizAnswer;
	}

	public Course getCourseQuizAnswer() {
		return courseQuizAnswer;
	}

	public void setCourseQuizAnswer(Course courseQuizAnswer) {
		this.courseQuizAnswer = courseQuizAnswer;
	}

	public Module getModuleQuizAnswer() {
		return moduleQuizAnswer;
	}

	public void setModuleQuizAnswer(Module moduleQuizAnswer) {
		this.moduleQuizAnswer = moduleQuizAnswer;
	}

	public UserQuizAnswer(Long user_quiz_question_answer, User userQuizAnswer, Course courseQuizAnswer,
			Module moduleQuizAnswer) {
		super();
		this.user_quiz_question_answer = user_quiz_question_answer;
		this.userQuizAnswer = userQuizAnswer;
		this.courseQuizAnswer = courseQuizAnswer;
		this.moduleQuizAnswer = moduleQuizAnswer;
	}

	@Override
	public String toString() {
		return "UserQuizAnswer [user_quiz_question_answer=" + user_quiz_question_answer + ", userQuizAnswer="
				+ userQuizAnswer + ", courseQuizAnswer=" + courseQuizAnswer + ", moduleQuizAnswer=" + moduleQuizAnswer
				+ "]";
	}
}

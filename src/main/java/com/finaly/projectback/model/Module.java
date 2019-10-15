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
@Table(name="web_module", schema="project")
public class Module {

	public Module() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long module_id;
	
	@Column(name="module_name")
	private String module_name;
	
	@Column(name="module_code")
	private String module_code;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	public Long getModule_id() {
		return module_id;
	}

	public void setModule_id(Long module_id) {
		this.module_id = module_id;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getModule_code() {
		return module_code;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Module(Long module_id, String module_name, String module_code, String description, Course course) {
		super();
		this.module_id = module_id;
		this.module_name = module_name;
		this.module_code = module_code;
		this.description = description;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Module [module_id=" + module_id + ", module_name=" + module_name + ", module_code=" + module_code
				+ ", description=" + description + ", course=" + course + "]";
	}
	
	@OneToMany(mappedBy = "module")
	private List<Lecture> modules = new ArrayList<Lecture>();
	
	public void addLecture(Lecture lecture) {
		this.modules.add(lecture);
		lecture.setModule(this);
	}
	
	@OneToMany(mappedBy = "moduleQuizQuestion")
	private List<QuizQuestion> moduleQuizQuestions = new ArrayList<QuizQuestion>();
	
	public void addModuleQuizQuestion(QuizQuestion moduleQuizQuestion) {
		this.moduleQuizQuestions.add(moduleQuizQuestion);
		moduleQuizQuestion.setModuleQuizQuestion(this);
	}
	
	@OneToMany(mappedBy = "moduleQuizAnswer")
	private List<UserQuizAnswer> moduleQuizAnswers = new ArrayList<UserQuizAnswer>();
	
	public void addUserQuizAnswer(UserQuizAnswer moduleQuizAnswer) {
		this.moduleQuizAnswers.add(moduleQuizAnswer);
		moduleQuizAnswer.setModuleQuizAnswer(this);
	}	
	
	
}

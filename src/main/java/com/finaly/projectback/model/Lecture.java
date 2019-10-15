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
@Table(name="web_lecture", schema="project")
public class Lecture {
	
	public Lecture() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long lecture_id;
	
	@Column(name="lecture_name")
	private String lecture_name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="video_url")
	private String video_url;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;
	
	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course courseLecture;

	public Long getLecture_id() {
		return lecture_id;
	}

	public void setLecture_id(Long lecture_id) {
		this.lecture_id = lecture_id;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Course getCourseLecture() {
		return courseLecture;
	}

	public void setCourseLecture(Course courseLecture) {
		this.courseLecture = courseLecture;
	}

	public Lecture(Long lecture_id, String lecture_name, String description, String video_url, Module module,
			Course courseLecture) {
		super();
		this.lecture_id = lecture_id;
		this.lecture_name = lecture_name;
		this.description = description;
		this.video_url = video_url;
		this.module = module;
		this.courseLecture = courseLecture;
	}

	@Override
	public String toString() {
		return "Lecture [lecture_id=" + lecture_id + ", lecture_name=" + lecture_name + ", description=" + description
				+ ", video_url=" + video_url + ", module=" + module + ", courseLecture=" + courseLecture + "]";
	}


}

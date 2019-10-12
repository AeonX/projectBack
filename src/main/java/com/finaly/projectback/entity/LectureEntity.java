package com.finaly.projectback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web_lecture")
public class LectureEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false) 
	private long id;
	
	@Column(name = "lecture_name")
	private String lecture_name;
	
	@Column(name = "lecture_description")
	private String lecture_description;
	
	@Column(name = "lecture_length")
	private String lecture_length;
	
	@Column(name = "course_id")
	private int course_id;
	
	@Column(name = "module_id")
	private int module_id;
	
	public LectureEntity() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public String getLecture_description() {
		return lecture_description;
	}

	public void setLecture_description(String lecture_description) {
		this.lecture_description = lecture_description;
	}

	public String getLecture_length() {
		return lecture_length;
	}

	public void setLecture_length(String lecture_length) {
		this.lecture_length = lecture_length;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public LectureEntity(long id, String lecture_name, String lecture_description, String lecture_length, int course_id,
			int module_id) {
		super();
		this.id = id;
		this.lecture_name = lecture_name;
		this.lecture_description = lecture_description;
		this.lecture_length = lecture_length;
		this.course_id = course_id;
		this.module_id = module_id;
	}

	@Override
	public String toString() {
		return "LectureModel [id=" + id + ", lecture_name=" + lecture_name + ", lecture_description="
				+ lecture_description + ", lecture_length=" + lecture_length + ", course_id=" + course_id
				+ ", module_id=" + module_id + "]";
	}	
}

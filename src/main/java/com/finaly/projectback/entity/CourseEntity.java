package com.finaly.projectback.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "web_course")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "course_id", updatable = false, nullable = false)
	private long course_id;

	@Column(name = "coursename")
	private String coursename;

	@Column(name = "description")
	private String description;
	
	@Column(name = "img_url")
	private String img_url;
	
	@OneToMany(mappedBy = "course_id", cascade = CascadeType.ALL, targetEntity=CourseEntity.class)
    private Set<ModuleEntity> moduleEntity;

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}



	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public CourseEntity() {
	}


	
	public CourseEntity(long course_id, String coursename, String description, String img_url, UserEntity userEntity) {
		super();
		this.course_id = course_id;
		this.coursename = coursename;
		this.description = description;
		this.img_url = img_url;
		this.userEntity = userEntity;
	}


	@Override
	public String toString() {
		return "CourseEntity [course_id=" + course_id + ", coursename=" + coursename + ", description=" + description
				+ ", img_url=" + img_url + ", moduleEntity=" + moduleEntity + ", userEntity=" + userEntity + "]";
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public CourseEntity(ModuleEntity... moduleEntity) {
        this.moduleEntity = Stream.of(moduleEntity).collect(Collectors.toSet());
        this.moduleEntity.forEach(x -> x.setCourseEntity(this));
    }
}

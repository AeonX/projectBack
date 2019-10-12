package com.finaly.projectback.entity;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "coursename")
	private String coursename;

	@Column(name = "description")
	private String description;
	
	@Column(name = "img_url")
	private String img_url;
	
	@OneToMany(mappedBy = "module_id", cascade = CascadeType.ALL)
    private Set<ModuleEntity> moduleEntity;

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public CourseEntity(UserEntity userEntity, long id, String coursename, String description, String img_url) {
		super();
		this.userEntity = userEntity;
		this.id = id;
		this.coursename = coursename;
		this.description = description;
		this.img_url = img_url;
	}

	@Override
	public String toString() {
		return "CourseEntity [userEntity=" + userEntity + ", id=" + id + ", coursename=" + coursename + ", description="
				+ description + ", img_url=" + img_url + "]";
	}
	
	@ManyToOne
	@JoinColumn
	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
//	public CourseEntity(ModuleEntity... moduleEntity) {
//        this.moduleEntity = Stream.of(moduleEntity).collect(Collectors.toSet());
//        this.moduleEntity.forEach(x -> x.setCourseEntity(this));
//    }
}

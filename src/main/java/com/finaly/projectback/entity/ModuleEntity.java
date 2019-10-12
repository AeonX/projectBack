package com.finaly.projectback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "web_module")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ModuleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "module_id", updatable = false, nullable = false) 
	private long module_id;
	
	@Column(name = "module_name")
	private String module_name;
	
	@Column(name = "module_code")
	private String module_code;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn
	private CourseEntity courseEntity;

	public ModuleEntity() {}

	public long getModule_id() {
		return module_id;
	}

	public void setModule_id(long module_id) {
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

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}

	public ModuleEntity(long module_id, String module_name, String module_code, String description,
			CourseEntity courseEntity) {
		super();
		this.module_id = module_id;
		this.module_name = module_name;
		this.module_code = module_code;
		this.description = description;
		this.courseEntity = courseEntity;
	}

	@Override
	public String toString() {
		return "ModuleEntity [module_id=" + module_id + ", module_name=" + module_name + ", module_code=" + module_code
				+ ", description=" + description + ", courseEntity=" + courseEntity + "]";
	}
}

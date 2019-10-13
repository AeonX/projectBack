package com.finaly.projectback.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "web_module")
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "web_module_ibfk_1"))
	private CourseEntity courseEntity;

	public ModuleEntity() {}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "module_id", unique = true, nullable = false)
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
	
	
	//////////////////////////////////////////////
	
	@OneToMany(mappedBy = "module_id", cascade = CascadeType.ALL)
    private Set<LectureEntity> lectureEntity;
	
	public ModuleEntity(LectureEntity... lectureEntity) {
        this.lectureEntity = Stream.of(lectureEntity).collect(Collectors.toSet());
        this.lectureEntity.forEach(x -> x.setModuleEntity(this));
    }
}

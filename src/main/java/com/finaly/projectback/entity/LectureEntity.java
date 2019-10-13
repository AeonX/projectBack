package com.finaly.projectback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "web_lecture")
public class LectureEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lecture_id", updatable = false, nullable = false) 
	private long lecture_id;
	
	@Column(name = "lecture_name")
	private String lecture_name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "video_url")
	private String video_url;
	
	public LectureEntity() {
		
	}
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private ModuleEntity moduleEntity;

	public long getLecture_id() {
		return lecture_id;
	}

	public void setLecture_id(long lecture_id) {
		this.lecture_id = lecture_id;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public ModuleEntity getModuleEntity() {
		return moduleEntity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setModuleEntity(ModuleEntity moduleEntity) {
		this.moduleEntity = moduleEntity;
	}

	public LectureEntity(long lecture_id, String lecture_name, String description, String video_url,
			ModuleEntity moduleEntity) {
		super();
		this.lecture_id = lecture_id;
		this.lecture_name = lecture_name;
		this.description = description;
		this.video_url = video_url;
		this.moduleEntity = moduleEntity;
	}

	@Override
	public String toString() {
		return "LectureEntity [lecture_id=" + lecture_id + ", lecture_name=" + lecture_name + ", description="
				+ description + ", video_url=" + video_url + ", moduleEntity=" + moduleEntity + "]";
	}


	
	
}

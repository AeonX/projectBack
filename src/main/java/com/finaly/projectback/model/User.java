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
@Table(name="web_user", schema="project")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long user_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="pwd")
	private String pwd;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public User() {
		
	}

	public User(Long user_id, String first_name, String last_name, String user_name, String pwd, Role role) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.pwd = pwd;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", user_name="
				+ user_name + ", pwd=" + pwd + ", role=" + role + "]";
	}
	
	@OneToMany(mappedBy = "user")
	private List<Course> users = new ArrayList<Course>();
	
	public void addCourse(Course course) {
		this.users.add(course);
		course.setUser(this);
	}
	
	@OneToMany(mappedBy = "studentEnrollment")
	private List<Enrollment> studentEnrollments = new ArrayList<Enrollment>();
	
	public void addCourse(Enrollment studentEnrollment) {
		this.studentEnrollments.add(studentEnrollment);
		studentEnrollment.setStudentEnrollment(this);
	}	
	
	@OneToMany(mappedBy = "userQuizAnswer")
	private List<UserQuizAnswer> userQuizAnswers = new ArrayList<UserQuizAnswer>();
	
	public void addUserQuizAnswer(UserQuizAnswer userQuizAnswer) {
		this.userQuizAnswers.add(userQuizAnswer);
		userQuizAnswer.setUserQuizAnswer(this);
	}	
}

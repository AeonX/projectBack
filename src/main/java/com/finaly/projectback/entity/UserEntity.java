package com.finaly.projectback.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "web_user")
public class UserEntity {
	
	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private Set<CourseEntity> courseEntity;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	private long user_id;
	
//	
//	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
//    private ArrayList<CourseEntity> courseEntity;

	

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "pwd")
	private String pwd;

	public UserEntity() {

	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public long getUser_id() {
		return user_id;
	}



	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserEntity(long user_id, String firstname, String lastname, String username, String email, String pwd) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", email=" + email + ", pwd=" + pwd + "]";
	}

	public UserEntity(CourseEntity... courseEntity) {
        this.courseEntity = Stream.of(courseEntity).collect(Collectors.toSet());
        this.courseEntity.forEach(x -> x.setUserEntity(this));
    }
}

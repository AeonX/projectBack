package com.finaly.projectback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="web_role", schema="project")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long role_id;
	
	@Column(name="role_name")
	private String role_name;

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role_name;
	}

	public void setRole(String role_name) {
		this.role_name = role_name;
	}
	
	public Role() {
		
	}

	public Role(Long role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + "]";
	}
	
	@OneToMany(mappedBy = "role")
	private List<User> roles = new ArrayList<User>();
	
	public void addUser(User user) {
		this.roles.add(user);
		user.setRole(this);
	}
	
	
	
	
}

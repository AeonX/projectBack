package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.Role;
import com.finaly.projectback.repo.RoleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/roles")
	@ResponseBody
	public List<Role> getRoles() {
		return (List<Role>) roleRepository.findAll();
	}

	@PostMapping("/roles")
	void addRole(@RequestBody Role role) {
		roleRepository.save(role);
	}
}

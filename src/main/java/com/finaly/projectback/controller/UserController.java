package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.User;
import com.finaly.projectback.model.UserStatus;
import com.finaly.projectback.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@PostMapping("/users")
	void addRole(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(produces = "application/json")
	@GetMapping({ "/validateLogin" })
	public UserStatus validateLogin() {
		return new UserStatus("User successfully authenticated");
	}
}

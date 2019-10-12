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

import com.finaly.projectback.entity.UserEntity;
import com.finaly.projectback.entity.UserStatusEntity;
import com.finaly.projectback.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class UserController {

//	boolean userExist = false;
//
	// standard constructors
	@Autowired
	private UserRepository userRepository;
//
//	@GetMapping("/test")
//	@ResponseBody
//	public String test() {
//		return "test";
//	}
//
//    @GetMapping("/users")
//    @ResponseBody
//    public List<UserEntity> getUsers() {
//    	System.out.println("entered");
//        return (List<UserEntity>) userRepository.findAll();
//    }
//    
    @GetMapping("/users")
    public List<UserEntity> getByUsername() {
    	return (List<UserEntity>) userRepository.findAll();
    }
 
  //  @GetMapping("/users")
//	@PostMapping(value = "/users")
//	public ResponseEntity<UserModel> findByUsername(@RequestBody UserModel user) {
//		UserModel searchUser = userRepository.findByUsername(user.getUsername());
//		UserModel emptyObj = new UserModel();
//
//		if (searchUser != null) {
//			return ResponseEntity.ok(searchUser);
//		}
//		return ResponseEntity.ok(emptyObj);
//	}

//	@GetMapping(value = "/users/")
//	public boolean userExist() {
//
//		if (userExist != false) {
//			return true;
//		}
//		return false;
//	}

	@RequestMapping(produces = "application/json")
	@GetMapping({ "/validateLogin" })
	public UserStatusEntity validateLogin() {
		System.out.println("entered");
		return new UserStatusEntity("User successfully authenticated");
	}
	
	@RequestMapping("/using")
    public String showUserMsg()
    {
        return "User has logged in!!!";

    }

	@PostMapping("/users")
	void addUser(@RequestBody UserEntity user) {
		userRepository.save(user);
	}
}
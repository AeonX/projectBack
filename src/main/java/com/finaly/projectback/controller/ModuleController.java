package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.model.Module;
import com.finaly.projectback.repo.ModuleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepository;
	
	@GetMapping("/modules")
	@ResponseBody
	public List<Module> getModules() {
		return (List<Module>) moduleRepository.findAll();
	}

	@PostMapping("/modules")
	void addModule(@RequestBody Module module) {
		moduleRepository.save(module);
	}
}

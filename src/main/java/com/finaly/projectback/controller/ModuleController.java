package com.finaly.projectback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaly.projectback.entity.CourseEntity;
import com.finaly.projectback.entity.ModuleEntity;
import com.finaly.projectback.entity.UserEntity;
import com.finaly.projectback.repo.ModuleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepository;
	
	@GetMapping("/modules")
	@ResponseBody
	public List<ModuleEntity> getModules() {
		return (List<ModuleEntity>) moduleRepository.findAll();
	}

	@PostMapping("/modules")
	void addModule(@RequestBody ModuleEntity module) {
		ModuleEntity moduleEntity = new ModuleEntity();
		CourseEntity courseEntity = new CourseEntity();
		moduleEntity.setCourseEntity(courseEntity);
		
		moduleRepository.save(module);
	}
}


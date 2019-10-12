package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finaly.projectback.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	public CourseEntity findByCoursename(String coursename);
	
	//public CourseEntity findByUserEntity_UserId(int user_id);
}

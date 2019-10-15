package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {

}

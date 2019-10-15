package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>  {

}

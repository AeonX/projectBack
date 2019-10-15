package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long>  {

}

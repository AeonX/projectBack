package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finaly.projectback.entity.LectureEntity;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity, Long> {

}

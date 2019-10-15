package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.QuizAnswer;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Long>  {

}

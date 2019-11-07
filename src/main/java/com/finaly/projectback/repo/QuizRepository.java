package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>   {

}

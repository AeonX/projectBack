package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.UserQuizAnswer;

public interface UserQuizAnswerRepository extends JpaRepository<UserQuizAnswer, Long>  {

}

package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}

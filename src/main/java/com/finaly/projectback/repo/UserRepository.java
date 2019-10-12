package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finaly.projectback.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findByUsername(String username);
	//public UserModel sendUsername();
}

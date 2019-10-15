package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>  {

}

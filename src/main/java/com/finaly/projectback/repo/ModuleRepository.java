package com.finaly.projectback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaly.projectback.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Long>  {

}

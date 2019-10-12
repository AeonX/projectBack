package com.finaly.projectback.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finaly.projectback.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends CrudRepository<ModuleEntity, Long> {

}

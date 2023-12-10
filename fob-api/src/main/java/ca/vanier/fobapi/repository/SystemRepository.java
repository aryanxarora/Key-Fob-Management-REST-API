package ca.vanier.fobapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.systemlib.entity.System;

@Repository
public interface SystemRepository extends CrudRepository<System, Long>{
    
}


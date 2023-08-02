package com.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.model.Loggers;

public interface UserSecurityRepository extends CrudRepository<Loggers, String> {
    
}

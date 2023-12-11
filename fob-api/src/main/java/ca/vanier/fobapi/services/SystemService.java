package ca.vanier.fobapi.services;

import java.util.Optional;

import ca.vanier.systemlib.entity.System;

public interface SystemService {
    System save(System s);
    
    Iterable<System> findAll();
    Optional<System> findById(Long id);
    
    void delete(Long id);
}

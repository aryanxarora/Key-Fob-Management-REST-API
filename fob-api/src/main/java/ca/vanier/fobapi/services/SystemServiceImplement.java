package ca.vanier.fobapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.fobapi.repository.SystemRepository;
import ca.vanier.systemlib.entity.System;

@Service
public class SystemServiceImplement implements SystemService {

    @Autowired
    private SystemRepository sr;

    @Override
    public System save(System s) {
        return sr.save(s);
    }

    @Override
    public Iterable<System> findAll(){
        return sr.findAll();
    }

    @Override
    public Optional<System> findById(Long id) {
        return sr.findById(id);
    }

    @Override
    public void delete(Long id) {
        sr.deleteById(id);
    }
    
}

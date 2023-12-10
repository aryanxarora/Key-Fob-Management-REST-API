package ca.vanier.fobapi.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ca.vanier.systemlib.entity.System;

@Service
public class SystemServiceImplement implements SystemService{

    // @Autowired
    // private SystemRepository sr;

    @Override
    public System save(System s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<System> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}

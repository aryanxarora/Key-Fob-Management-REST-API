package ca.vanier.fobapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.fobapi.repository.FobRepository;
import ca.vanier.systemlib.entity.Fob;

@Service
public class FobServiceImplement implements FobService{

    @Autowired
    private FobRepository fr;

    @Override
    public Fob save(Fob f) {
        return fr.save(f);
    }

    @Override
    public Optional<Fob> findById(Long id) {
        return fr.findById(id);
    }

    @Override
    public void delete(Long id) {
        fr.deleteById(id);
    }
    
}

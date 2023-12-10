package ca.vanier.fobapi.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ca.vanier.systemlib.entity.Fob;

@Service
public class FobServiceImplement implements FobService{

    // @Autowired
    // private FobRepository fr;

    @Override
    public Fob save(Fob f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Fob> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}

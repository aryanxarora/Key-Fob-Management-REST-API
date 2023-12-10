package ca.vanier.fobapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ca.vanier.fobapi.repository.UserRepository;
import ca.vanier.systemlib.entity.User;

public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository ur;
    
    @Override
    public User save(User s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}

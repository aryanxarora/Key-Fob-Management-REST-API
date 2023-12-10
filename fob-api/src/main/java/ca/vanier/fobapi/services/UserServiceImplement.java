package ca.vanier.fobapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.fobapi.repository.UserRepository;
import ca.vanier.systemlib.entity.User;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository ur;
    
    @Override
    public User save(User u) {
        return ur.save(u);
    }

    @Override
    public Optional<User> findById(Long id) {
        return ur.findById(id);
    }

    @Override
    public void delete(Long id) {
        ur.deleteById(id);
    }
    
}

package ca.vanier.fobapi.services;

import java.util.Optional;

import ca.vanier.systemlib.entity.User;

public interface UserService {
    User save(User s);

    Optional<User> findById(Long id);
    void delete(Long id);
}
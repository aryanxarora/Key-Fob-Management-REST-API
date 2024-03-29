package ca.vanier.fobapi.services;

import java.util.Optional;

import ca.vanier.systemlib.entity.Client;

public interface ClientService {
    Client save(Client s);

    void saveAll(Iterable<Client> c);
    
    Iterable<Client> findAll();
    Optional<Client> findById(Long id);
    
    void delete(Long id);
}
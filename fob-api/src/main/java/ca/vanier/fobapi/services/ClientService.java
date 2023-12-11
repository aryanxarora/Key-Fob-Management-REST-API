package ca.vanier.fobapi.services;

import java.util.Optional;

import ca.vanier.systemlib.entity.Client;

public interface ClientService {
    Client save(Client s);

    void saveAll(Iterable<Client> c);

    Optional<Client> findById(Long id);

    Iterable<Client> findAll();
    void delete(Long id);
}
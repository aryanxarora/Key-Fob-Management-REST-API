package ca.vanier.fobapi.services;

import java.util.Optional;

import ca.vanier.systemlib.entity.Fob;

public interface FobService {
    Fob save(Fob f);

    Iterable<Fob> findAll();
    Optional<Fob> findById(Long id);
    void delete(Long id);
}

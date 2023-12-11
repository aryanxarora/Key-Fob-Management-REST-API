package ca.vanier.fobapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.systemlib.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    
}


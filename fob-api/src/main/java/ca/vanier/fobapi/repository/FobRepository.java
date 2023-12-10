package ca.vanier.fobapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.systemlib.entity.Fob;

@Repository
public interface FobRepository extends CrudRepository<Fob, Long>{
    
}

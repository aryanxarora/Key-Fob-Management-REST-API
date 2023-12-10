package ca.vanier.fobapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.systemlib.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}


package ca.vanier.fobapi.services;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.fobapi.repository.ClientRepository;
import ca.vanier.systemlib.entity.Client;

@Service
public class ClientServiceImplement implements ClientService{

    @Autowired
    private ClientRepository cr;
    
    @Override
    public Client save(Client c) {
        return cr.save(c);
    }

    @Override
    public void saveAll(Iterable<Client> c){
        cr.saveAll(c);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return cr.findById(id);
    }

    @Override
    public Iterable<Client> findAll(){
        return cr.findAll();
    }

    @Override
    public void delete(Long id) {
        cr.deleteById(id);
    }
    
}

package ca.vanier.systemlib.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class System {

    @Id
    @GeneratedValue
    private Long systemId;


    private List<Long> clients;
    // Payment Library
    
    // ToString
    @Override
    public String toString() {
        return "System [systemId: " + systemId + " | clients: " + "]";
    }
}
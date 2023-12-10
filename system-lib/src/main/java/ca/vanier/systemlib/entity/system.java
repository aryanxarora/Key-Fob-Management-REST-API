package ca.vanier.systemlib.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class system {

    @Id
    @GeneratedValue
    private Long systemId;
    private List<user> users;
    // Payment Library
    
    // ToString
    @Override
    public String toString() {
        return "System [systemId: " + systemId + " | users: " + users + "]";
    }
}

package ca.vanier.systemlib.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fob {
    
    @Id
    @GeneratedValue
    private Long fobId;
    private Long clientId;
    private Date expiryDate; //date will always be date-1

    // ToString
    @Override
    public String toString() {
        return "Fob [fobId: " + fobId + " | clientId: " + clientId + " | expiryDate: " + expiryDate + "]";
    }
}

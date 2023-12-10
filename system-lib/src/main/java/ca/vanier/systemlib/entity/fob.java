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
public class fob {
    
    @Id
    @GeneratedValue
    private Long fobId;
    private Long userId;
    private Date expiryDate;

    // ToString
    @Override
    public String toString() {
        return "Fob [fobId: " + fobId + " | userId: " + userId + " | expiryDate: " + expiryDate + "]";
    }
}

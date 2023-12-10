package ca.vanier.systemlib.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class fob {
    
    @Id
    @GeneratedValue
    private Long fobId;
    private Long userId;
    private Date expiryDate;

    //Getters
    public Long getFobId(){ return fobId; }
    public Long getUserId(){ return userId; }
    public Date getExpiryDate(){ return expiryDate; }

    //Setters
    public void setFobId(Long fobId){ this.fobId = fobId; }
    public void setUserId(Long userId){ this.userId = userId; }
    public void setExpiryDate(Date expiryDate){ this.expiryDate = expiryDate; }

    // ToString
    @Override
    public String toString() {
        return "Fob [fobId: " + fobId + " | userId: " + userId + " | expiryDate: " + expiryDate + "]";
    }
}

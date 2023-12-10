package ca.vanier.systemlib.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class system {

    @Id
    @GeneratedValue
    private Long systemId;
    private List<user> users;
    // Payment Library

    //Getters
    public Long getSystemId() { return systemId; }
    public List<user> getUsers() { return users; }

    //Setters
    public void setSystemId(Long systemId) { this.systemId = systemId; }
    public void setUsers(List<user> users) { this.users = users; }
    
    // ToString
    @Override
    public String toString() {
        return "System [systemId: " + systemId + " | users: " + users + "]";
    }
}

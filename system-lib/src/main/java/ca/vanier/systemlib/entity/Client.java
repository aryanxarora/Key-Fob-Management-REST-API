package ca.vanier.systemlib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private Long clientId;
    private String firstName;
    private String lastName;
    private String address;
    private String postal;
    private String phoneNumber;
    private String email;
    private String ccNum;
    private String ccExp;
    private String ccCvc;
    private boolean status;

    // ToString
    @Override
    public String toString() {
        return "User [clientId: " + clientId + 
                " | firstName: " + firstName + 
                " | lastName: " + lastName + 
                " | address: " + address + 
                " | postal: " + postal + 
                " | phoneNumber: " + phoneNumber + 
                " | email: " + phoneNumber + 
                " | ccNum: " + ccNum + 
                " | ccExp: " + ccExp + 
                " | ccCvc: " + ccCvc + 
                " | status: " + status + 
                "]";
    }
}
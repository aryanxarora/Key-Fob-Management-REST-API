package ca.vanier.systemlib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class user {

    @Id
    @GeneratedValue
    private Long userId;
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

    // Getters
    public Long getUserId(){ return userId; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getAddress(){ return address; }
    public String getPostal(){ return postal; }
    public String getPhoneNumber(){ return phoneNumber; }
    public String getEmail(){ return email; }
    public String getCcNum(){ return ccNum; }
    public String getCcExp(){ return ccExp; }
    public String getCcCvc(){ return ccCvc; }
    public boolean getStatus(){ return status; }

    // Setters
    public void setUserId(Long userId){ this.userId = userId; }
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setAddress(String address){ this.address = address; }
    public void setPostal(String postal){ this.postal = postal; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }
    public void setEmail(String email){ this.email = email; }
    public void setCcNum(String ccNum){ this.ccNum = ccNum; }
    public void setCcExp(String ccExp){ this.ccExp = ccExp; }
    public void setCcCvc(String ccCvc){ this.ccCvc = ccCvc; }
    public void setStatus(boolean status){ this.status = status; }

    // ToString
    @Override
    public String toString() {
        return "User [userId: " + userId + 
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
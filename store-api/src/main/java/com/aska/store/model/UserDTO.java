package com.aska.store.model;

import com.aska.store.entity.AddressEntity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int phoneNumber;
    private Set<AddressEntity> addressEntities;

    public UserDTO() {
    }

    public UserDTO(long id, String firstName, String lastName, String password, String email, int phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}

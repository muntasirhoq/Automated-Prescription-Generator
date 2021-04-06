package com.sd.Models;

import javax.persistence.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Entity
public class Profile {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String designation;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    private String email;

    public Profile() {}

    public Profile(long id, String name, String phoneNumber, String address, String designation, String email) {
        this.id=id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.designation = designation;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

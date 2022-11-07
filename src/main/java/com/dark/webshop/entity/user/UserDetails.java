package com.dark.webshop.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "userdetailscatalog")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "firstname")
    private String FirstName;
    @Column(name = "lastname")
    private String LastName;
    @Column(name = "phonenumber")
    private String PhoneNumber;
    @Column(name = "adress")
    private String Adress;

    public UserDetails() {
    }

    public UserDetails(Integer id, String firstName, String lastName, String phoneNumber, String adress) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Adress = adress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
}

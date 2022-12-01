package com.dark.webshop.service.model;


import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    List<OrderedFoodModel> orderedFoodCard = new ArrayList<>();


    public UserModel() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderedFoodModel> getOrderedFoodCard() {
        return orderedFoodCard;
    }

    public void setOrderedFoodCard(List<OrderedFoodModel> orderedFoodCard) {
        this.orderedFoodCard = orderedFoodCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

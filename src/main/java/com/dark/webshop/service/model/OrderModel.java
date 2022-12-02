package com.dark.webshop.service.model;


import java.sql.Timestamp;
import java.util.List;

public class OrderModel {
    private Integer id;
    private UserModel user;
    private String phone;
    private String address;
    private boolean confirmed = false;
    private Timestamp timestamp;
    private List<OrderedFoodModel> orderedFoodList;

    public OrderModel() {
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }



    public List<OrderedFoodModel> getOrderedFoodList() {
        return orderedFoodList;
    }

    public void setOrderedFoodList(List<OrderedFoodModel> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }
}

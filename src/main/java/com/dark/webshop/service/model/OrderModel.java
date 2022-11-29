package com.dark.webshop.service.model;

import com.dark.webshop.database.entity.user.User;

import java.sql.Date;
import java.util.List;

public class OrderModel {
    private Integer id;
    private User user;
    private boolean confirmed;
    private Date datetime;
    private List<OrderedFoodModel> orderedFoodList;

    public OrderModel() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public List<OrderedFoodModel> getOrderedFoodList() {
        return orderedFoodList;
    }

    public void setOrderedFoodList(List<OrderedFoodModel> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }
}

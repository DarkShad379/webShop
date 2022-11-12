package com.dark.webshop.service.model;

import com.dark.webshop.database.entity.food.OrderedFood;
import com.dark.webshop.database.entity.user.User;

import java.sql.Date;
import java.util.List;

public class OrderModel {
    private Integer id;
    private User user;
    private boolean confirmed;
    private Date datetime;
    public OrderModel() {
    }
    public OrderModel(Integer id, User user, boolean confirmed, Date datetime, List<OrderedFood> orderedFoodList) {
        this.id = id;
        this.user = user;
        this.confirmed = confirmed;
        this.datetime = datetime;
        this.orderedFoodList = orderedFoodList;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    private List<OrderedFood> orderedFoodList;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderedFood> getOrderedFoodList() {
        return orderedFoodList;
    }

    public void setOrderedFoodList(List<OrderedFood> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }

}

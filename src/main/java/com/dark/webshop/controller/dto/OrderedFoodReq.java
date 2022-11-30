package com.dark.webshop.controller.dto;

import java.util.List;

public class OrderedFoodReq {
    private Integer id;
    private Integer foodId;
    private Integer orderId;
    private Integer totalfoodcost;
    private List<Integer> additionalListId;

    public OrderedFoodReq() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTotalfoodcost() {
        return totalfoodcost;
    }

    public void setTotalfoodcost(Integer totalfoodcost) {
        this.totalfoodcost = totalfoodcost;
    }

    public List<Integer> getAdditionalListId() {
        return additionalListId;
    }

    public void setAdditionalListId(List<Integer> additionalListId) {
        this.additionalListId = additionalListId;
    }
}

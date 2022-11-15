package com.dark.webshop.service.model;

import java.util.List;

public class OrderedFoodModel {

    private Integer id;
    private FoodModel food;
    private Integer orderId;
    private Integer totalfoodcost;
    private List<AdditionalModel> additionalList;

    public OrderedFoodModel() {
    }

    public OrderedFoodModel(Integer id, FoodModel food, Integer orderId, Integer totalfoodcost, List<AdditionalModel> additionalList) {
        this.id = id;
        this.food = food;
        this.orderId = orderId;
        this.totalfoodcost = totalfoodcost;
        this.additionalList = additionalList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FoodModel getFood() {
        return food;
    }

    public void setFood(FoodModel food) {
        this.food = food;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTotalFoodCost() {
        return totalfoodcost;
    }

    public void setTotalFoodCost(Integer totalFoodCost) {
        this.totalfoodcost = totalFoodCost;
    }

    public List<AdditionalModel> getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(List<AdditionalModel> additionalList) {
        this.additionalList = additionalList;
    }
}

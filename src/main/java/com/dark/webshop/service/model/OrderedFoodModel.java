package com.dark.webshop.service.model;

import java.util.List;

public class OrderedFoodModel {

    private Integer id;
    private FoodModel food;
    private Integer totalfoodcost;
    private List<AdditionalModel> additionalList;

    public OrderedFoodModel() {
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

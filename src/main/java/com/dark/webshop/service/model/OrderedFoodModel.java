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

    public Integer getTotalfoodcost() {
        return totalfoodcost;
    }

    public void setTotalfoodcost(Integer totalfoodcost) {
        this.totalfoodcost = totalfoodcost;
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



    public List<AdditionalModel> getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(List<AdditionalModel> additionalList) {
        this.additionalList = additionalList;
    }
}

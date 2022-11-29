package com.dark.webshop.service.model;


import java.util.ArrayList;
import java.util.List;

public class FoodModel {
    private Integer id;
    private String name;
    private byte[] image;
    private String description;
    private Integer cost;
    private FoodCategoryModel foodCategory;
    private List<AdditionalModel> availableAdditionalList = new ArrayList<>();
    private boolean deleted = false;


    public FoodModel() {
    }

    public FoodCategoryModel getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategoryModel foodCategory) {
        this.foodCategory = foodCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }



    public List<AdditionalModel> getAvailableAdditionalList() {
        return availableAdditionalList;
    }

    public void setAvailableAdditionalList(List<AdditionalModel> availableAdditionalList) {
        this.availableAdditionalList = availableAdditionalList;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

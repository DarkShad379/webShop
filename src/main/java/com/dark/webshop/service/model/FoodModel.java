package com.dark.webshop.service.model;



import com.dark.webshop.database.entity.food.FoodCategory;

import java.util.List;

public class FoodModel {
    private Integer id;
    private String name;
    private byte[] image;
    private String description;
    private Integer cost;
    private FoodCategory foodCategory;
    private List<AdditionalModel> availableAdditionalList;
    private boolean deleted=false;

    public FoodModel(Integer id, String name, byte[] image, String description, Integer cost, FoodCategory foodCategory, List<AdditionalModel> availableAdditionalList, boolean deleted) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.cost = cost;
        this.foodCategory = foodCategory;
        this.availableAdditionalList = availableAdditionalList;
        this.deleted = deleted;
    }

    public FoodModel() {
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

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
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

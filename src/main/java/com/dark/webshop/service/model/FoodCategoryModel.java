package com.dark.webshop.service.model;


public class FoodCategoryModel {
    int id;
    private String name;

    public FoodCategoryModel(int categoryId, String name) {
        this.id = categoryId;
        this.name = name;
    }

    public FoodCategoryModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

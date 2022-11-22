package com.dark.webshop.service.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FoodCategoryModel {
    int id;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 3, message = "Название должно быть не короче 2х символов!")
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

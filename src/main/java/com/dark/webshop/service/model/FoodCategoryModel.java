package com.dark.webshop.service.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class FoodCategoryModel {
    Integer id;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 3, message = "Название должно быть не короче 2х символов!")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodCategoryModel that = (FoodCategoryModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public FoodCategoryModel(int categoryId, String name) {
        this.id = categoryId;
        this.name = name;
    }

    public FoodCategoryModel(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public FoodCategoryModel() {
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
}
